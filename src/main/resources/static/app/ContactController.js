(function () {
    'use strict';

    angular.module('nsdi')
        .controller('ContactController', ContactController);

    ContactController.$inject = ['$http'];

    function ContactController($http) {
        var cc = this;
        cc.contacts = [];
        cc.deleteContact = deleteContact;
        cc.search = search;
        cc.logout = logout;
        cc.editClick = editClick;
        cc.saveContact = saveContact;
        cc.clearVariables = clearVariables;
        cc.phoneNumberPattern = /^[0-9\+\-]*$/;
        cc.id = 0;
        cc.firstName = "";
        cc.lastName = "";
        cc.phoneNumber = "";

        init();

        function init() {
            search();
        }

        function logout() {
            window.location.href = '/logout';
        }

        function search(firstName, lastName, phoneNumber) {
            var params = {};
            if (firstName) {
                params.firstName = firstName
            }
            if (lastName) {
                params.lastName = lastName;
            }
            if (phoneNumber) {
                params.phoneNumber = phoneNumber;
            }
            cc.loading = true;
            var contacts = $http.get("/contacts", {
                params: params
            });
            contacts.then(function (resp) {
                cc.contacts = resp.data;
                cc.loading = false;
            });
        }

        function editClick(contact) {
            if (!contact) return;
            cc.firstName = contact.firstName;
            cc.lastName = contact.lastName;
            cc.phoneNumber = contact.phoneNumber;
            cc.id = contact.id;
        }

        function saveContact() {
            if(!cc.phoneNumberPattern.test(cc.phoneNumber)){
                return;
            }

            var contact = {
                firstName: cc.firstName,
                lastName: cc.lastName,
                phoneNumber: cc.phoneNumber,
                active:true
            };

            if (!cc.id) {
                addContact(contact);
            } else {
                updateContact(contact,cc.id);
            }
            clearVariables();
        }

        function addContact(contact) {
            if(!contact) return;
            $http.post("/contacts", JSON.stringify(contact), {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function () {
                search();
            }).catch(function (res) {
                alert(res.data.message)
            });
        }

        function updateContact(contact,id) {
            if(!contact) return;
            $http.patch("/contacts/"+id,JSON.stringify(contact), {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function () {
                search();
            }).catch(function (res) {
                alert(res.data.message)
            });
        }

        function deleteContact(id) {
            if (!id) return;
            $http.delete("/contacts/" + id).then(function () {
                search();
            }).catch(function (res) {
                alert(res.data.message)
            });
        }

        function clearVariables() {
            cc.id = 0;
            cc.firstName = "";
            cc.lastName = "";
            cc.phoneNumber = "";
        }
    }
})();