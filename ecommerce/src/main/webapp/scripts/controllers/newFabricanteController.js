
angular.module('ecommerce').controller('NewFabricanteController', function ($scope, $location, locationParser, FabricanteResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.fabricante = $scope.fabricante || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Fabricantes/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        FabricanteResource.save($scope.fabricante, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Fabricantes");
    };
});