app.controller('EmployeeDetailsController', ['$scope', '$http', function($scope, $http) {
    $scope.totalMessages = 5000;
    $scope.unreadMessages = 4;
    $scope.deadline = "2024/07/03";
    $scope.formData = {};


    $scope.sendMessage = function() {
             console.log($scope.formData);
                $http({
                    method: 'POST',
                    headers: {
                        'ngrok-skip-browser-warning': 'hello',
                        'Content-Type': 'application/json'
                    },
                    data: $scope.formData,
                    url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/messages',
                }).then(function(response) {
                    // Success callback
                    console.log('Employees:', response);
                    $scope.formData = {};
                }, function(error) {
                    // Error callback
                    console.error('Error fetching employees:', error);
                    $scope.formData = {};
                });
    };

    $scope.clearForm = function() {
         $scope.formData = {};
    };
}]);

app.controller('MessagesController', ['$scope', '$http', function($scope, $http) {
    $scope.formData = {};
    $scope.replyMessage = function(message_from) {
        $scope.formData.number = message_from;
    }

    $http({
        method: "GET",
        headers: {
         'ngrok-skip-browser-warning': 'hello'
        },
        url:  'https://stallion-holy-informally.ngrok-free.app/api/v1/messages',
    }).then(function(response) {
        $scope.messages = response.data;
        console.log($scope.messages);
    }, function(error) {
        console.error("Error fetching employees: ", error);
    });

     $scope.sendMessage = function() {
         console.log($scope.formData);
            $http({
                method: 'POST',
                headers: {
                    'ngrok-skip-browser-warning': 'hello',
                    'Content-Type': 'application/json'
                },
                data: $scope.formData,
                url: 'https://stallion-holy-informally.ngrok-free.app/api/v1/messages',
            }).then(function(response) {
                // Success callback
                console.log('Employees:', response);
                $scope.formData = {};
            }, function(error) {
                // Error callback
                console.error('Error fetching employees:', error);
                $scope.formData = {};
            });
     };

     $scope.clearForm = function() {
         $scope.formData = {};
     }
}]);