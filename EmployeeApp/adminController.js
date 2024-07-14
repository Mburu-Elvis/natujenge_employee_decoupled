app.controller('AdminController', ['$scope', '$http', '$route', function($scope, $http, $route) {
    $scope.employeeForm={};
     $scope.openModal = function(employee) {
          $scope.selectedEmployee = angular.copy(employee); // Create a copy of the employee to edit
     };
    $http({
        method: 'GET',
        headers: {
                    'ngrok-skip-browser-warning': 'hello'
                },
        url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees/pagination',
    }).then(function(response) {
        $scope.pageNumber = response.data.pageable.pageNumber;
        $scope.employees = response.data.content;
        console.log("Page", $scope.pageNumber);
        console.log('Employees:', $scope.employees.content);
    }, function(error) {
        // Error callback
        console.error('Error fetching employees:', error);
    });

    $scope.createEmployee = function() {
        $http({
            method: 'POST',
            headers: {
                'ngrok-skip-browser-warning': 'hello',
                'Content-Type': 'application/json'
            },
            data: $scope.employeeForm,
            url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees',
        }).then(function(response) {
            // Success callback
            console.log('Employees:', response);
            $scope.refreshEmployees();
        }, function(error) {
            // Error callback
            console.error('Error fetching employees:', error);
            $scope.refreshEmployees();
        });
    };

    $scope.updateEmployee = function() {
        $http({
            method: 'PUT',
            headers: {
                'ngrok-skip-browser-warning': 'hello',
                'Content-Type': 'application/json'
            },
            data: $scope.selectedEmployee,
            url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees',
        }).then(function(response) {
            // Success callback
            console.log('Employees:', response);
            $scope.refreshEmployees();
        }, function(error) {
            // Error callback
            console.error('Error fetching employees:', error);
            $scope.refreshEmployees();
        });
    };

    $scope.deleteEmployee = function(employeeId) {
        $http({
            method: 'DELETE',
            headers: {
                'ngrok-skip-browser-warning': 'hello',
                'Content-Type': 'application/json'
            },
            data: $scope.employeeForm,
            url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/employees/' + employeeId
        }).then(function(response) {
            // Success callback
            console.log('Employee deleted:', response);
            // Display success message to the user
            $scope.successMessage = 'Employee deleted successfully!';
            $scope.errorMessage = ''; // Clear any previous error message
            $scope.refreshEmployees();
        }, function(error) {
            // Error callback
            console.error('Error deleting employee:', error);
            // Display error message to the user
            $scope.errorMessage = 'Failed to delete employee. Please try again later.';
            $scope.successMessage = ''; // Clear any previous success message
            $scope.refreshEmployees();
        });
    };

    $scope.refreshEmployees = function() {
        $route.reload();
        console.log("Refresh clicked");
    }
}]);