

angular.module('ecommerce').controller('EditFabricanteController', function($scope, $routeParams, $location, FabricanteResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.fabricante = new FabricanteResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/Fabricantes");
        };
        FabricanteResource.get({FabricanteId:$routeParams.FabricanteId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.fabricante);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.fabricante.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Fabricantes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Fabricantes");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.fabricante.$remove(successCallback, errorCallback);
    };
    
    
    $scope.get();
});