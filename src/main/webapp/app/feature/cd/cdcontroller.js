
(function() {

    var cdController = function(cdListService) {

        var vm = this;

        vm.sortBy ='Artist';
        vm.reverse=false;


        vm.sortNow = function(param)
        {
            vm.sortBy = param;
            vm.reverese= !$scope.reverse

        };

        function init() {
            cdListService.getCd().then(function (results) {
                console.log("In cd controller about to return data to the client with results " + results);
                vm.cd  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('cdStore').controller('cdController', ['cdListService', cdController]);

})();
