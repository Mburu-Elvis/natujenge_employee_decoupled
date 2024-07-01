app.controller('EmployeeDetailsController', function($scope) {
    $scope.totalMessages = 5000;
    $scope.unreadMessages = 4;
    $scope.deadline = "2024/07/03";
});

app.controller('MessagesController', ['$scope', '$http', function($scope, $http) {
    $scope.formData = {};
    $scope.messages = [
        {
            from: "+254712345678",
            message: "Hello, how are you?",
            status: "read"
        },
        {
            from: "+254701234567",
            message: "Hey, can you check the report and send me your feedback?",
            status: "unread"
        },
        {
            from: "+254732345678",
            message: "Meeting scheduled for tomorrow at 10 AM in the conference room.",
            status: "read"
        },
        {
            from: "+254722345678",
            message: "Reminder: Please complete your project status update by end of day.",
            status: "unread"
        },
        {
            from: "+254712345679",
            message: "URGENT: Server maintenance scheduled tonight at midnight. Prepare accordingly.",
            status: "unread"
        },
        {
            from: "+254733445566",
            message: "Congratulations on completing the project ahead of schedule! Great job!",
            status: "read"
        },
        {
            from: "+254711234567",
            message: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed malesuada turpis sit amet turpis lacinia placerat.",
            status: "unread"
        },
        {
            from: "+254701888380",
            message: "Proin consectetur lobortis nibh, a consectetur lorem. Fusce quis purus a sem ullamcorper placerat. obortis nibh, a consectetur lorem. Fusce quis purus a sem ullamcorper obortis nibh, a consectetur lorem. Fusce quis purus a sem ullamcorper",
            status: "unread"
        }
    ]; 

    $scope.sendMessage = function() {
        console.log($scope.formData);
        $http.post('http://127.0.0.1:8080/send-messages', $scope.formData)
                .then(function(response) {
                    // Handle success
                    console.log('Form submission successful!', response.data);
                    // Optionally reset the form
                    $scope.formData = {};
                }, function(error) {
                    // Handle error
                    console.error('Form submission failed!', error);
                });
        $scope.formData = {};
    }
}]);