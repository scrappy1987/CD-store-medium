
(function(){

    angular.module('cdStore').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/cd");

        $stateProvider.state("cd", {
            url: "/cd",
            templateUrl: "app/features/cd/cd.html"

        }).state("aboutUs", {
            url: "/aboutUs",
            templateUrl: "app/features/aboutUs/aboutUs.html"

        })
    });
}());
