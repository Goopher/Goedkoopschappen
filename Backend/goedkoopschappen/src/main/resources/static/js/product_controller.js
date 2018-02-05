'use strict';

angular.module('myApp').controller('ProductController', ['$scope', '$http', function ($scope, $http) {
    var REST_SERVICE_URI = 'http://localhost:8080/products/';
    var self = this;
    self.product = {
        productId: 0,
        productName: '',
        brandName: '',
        description: '',
        price: 0,
        houseBrand: 0,
        productUrl: '',
        imageUrl: ''
    };
    self.product = {};
    self.products = [];


    $scope.search = getBySearchString;


    function getBySearchString() {
        $http.get(REST_SERVICE_URI, {params: $scope.product})
            .then(function (response) {
                    self.products = response.data;
                    $scope.results = self.products;
                    console.log(response.data);
                },
                function error(errResponse) {
                    console.error('Error while fetching Users');
                });
    }
}]);
