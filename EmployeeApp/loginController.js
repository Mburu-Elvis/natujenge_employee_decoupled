app.controller('LoginController', ['$scope', '$http', function($scope, $http) {
    $scope.signupForm = {};
    $scope.error = false;
    $scope.password = null;
    $scope.passwordConfirmation = null;
    $scope.signUp = function() {
        console.log("Clicked");
        if ($scope.signupForm.password !== $scope.signupForm.passwordConfirmation ) {
            $scope.data = "Your passwords don't match" + $scope.signupForm.passwordConfirmation ;
        }
        $scope.error = true;
    }

}])