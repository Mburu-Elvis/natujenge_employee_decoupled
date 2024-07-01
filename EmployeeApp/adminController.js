app.controller('AdminController', ['$scope', '$http', function($scope) {
    $scope.employees = [
        {
            phoneNumber: '245723456798',
            email: 'johndoe@gmail.com',
            department: 'Finance',
            status: 'ACTIVE'
        },
        {
            phoneNumber: '245723456799',
            email: 'janedoe@gmail.com',
            department: 'Marketing',
            status: 'INACTIVE'
        },
        {
            phoneNumber: '245723456700',
            email: 'bobsmith@gmail.com',
            department: 'HR',
            status: 'ACTIVE'
        },
        {
            phoneNumber: '245723456701',
            email: 'alicewilliams@gmail.com',
            department: 'IT',
            status: 'ACTIVE'
        },
        {
            phoneNumber: '245723456702',
            email: 'michaelbrown@gmail.com',
            department: 'Sales',
            status: 'INACTIVE'
        },
        {
            phoneNumber: '245723456703',
            email: 'emilydavis@gmail.com',
            department: 'Finance',
            status: 'ACTIVE'
        },
        {
            phoneNumber: '245723456704',
            email: 'davidmiller@gmail.com',
            department: 'Marketing',
            status: 'ACTIVE'
        },
        {
            phoneNumber: '245723456705',
            email: 'sarahjohnson@gmail.com',
            department: 'HR',
            status: 'INACTIVE'
        },
        {
            phoneNumber: '245723456706',
            email: 'chrislee@gmail.com',
            department: 'IT',
            status: 'ACTIVE'
        },
        {
            phoneNumber: '245723456707',
            email: 'amandawilson@gmail.com',
            department: 'Sales',
            status: 'ACTIVE'
        }
    ];

}]);