(function() {

    var CdService =  function(cdDal) {

        this.getCds = function()
        {
            return cdDal.getCds();
        };
    };

    angular.module('cdStore').service('cdService', ['cdDal', CdService]);
}());