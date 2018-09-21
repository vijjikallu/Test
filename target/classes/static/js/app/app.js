var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/employee-dashboard',
    EMPLOYEE_SERVICE_API : 'http://localhost:8081/employee-dashboard/api/employee/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'EmployeeController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, EmployeeService) {
                        console.log('Load all employees');
                        var deferred = $q.defer();
                        EmployeeService.loadAllEmployees().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

