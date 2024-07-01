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
        .otherwise({ redirectTo: '/'});

})