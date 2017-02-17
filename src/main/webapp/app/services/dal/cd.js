"use strict";

(function () {

    angular.module("cdStore").service("cdDal", ["dal", CdDal]);

    function CdDal (dal) {

        this.getCds = function () {
            return dal.http.GET("rest/cdstore/json");
        };

        this.saveCd = function (cdToSave) {
            return dal.http.POST("rest/cdstore/json", cdToSave);
        };

        this.updateCd = function (cdToUpdate) {
            return dal.http.PUT("rest/cdstore/json/", cdToUpdate);
        };

        this.deleteCd = function (cdToDelete) {
            return dal.http.DELETE("/rest/cdstore/json/", cdToDelete);
        };

    }
}());