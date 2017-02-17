/**
 * Created by Administrator on 16/02/2017.
 */
(function() {

    function cdDal (dal) {

        angular.module('cdStore').service('cdDal', ['dal' , cdDal]);

        this.getMovies = function () {

            return dal.http.GET("rest/cdStore/json");

        };

        this.saveMovie = function (cdToSave) {

            return dal.http.POST("rest/cdStore/json");

        };

        this.updateMovie = function (cdToUpdate) {

            return dal.http.PUT("rest/cdStore/json");

        };

        this.deleteMovie = function (cdToDelete) {

            return dal.http.DELETE("rest/cdStores/json");
        };
    };

}());