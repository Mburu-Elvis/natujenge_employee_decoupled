var app = angular.module("myApp", ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'employee.html'
        })
        .when('/Admin', {
            templateUrl: 'admin.html',
            controller: 'AdminController'
        })
        .when('/Jobs', {
            templateUrl: 'jobs.html',
            controller: 'JobsController'
        })
        .when('/Client',{
            templateUrl: 'client.html',
            controller: 'ClientController'
        })
        .when('/Login', {
            templateUrl: 'login.html',
            controller: 'LoginController'
        })
        .otherwise({ redirectTo: '/'});

})