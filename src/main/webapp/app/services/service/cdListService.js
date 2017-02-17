(function() {

    var cdListService = function(cdDal) {


        this.getcd = function() {
            return cdDal.getcd();
        };

    };

    angular.module('cdStore').service('cdListService', ['cdDal', cdListService])
}());

