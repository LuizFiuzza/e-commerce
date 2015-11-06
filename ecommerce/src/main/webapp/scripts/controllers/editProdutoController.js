

angular.module('ecommerce').controller('EditProdutoController', function($scope, $routeParams, $location, ProdutoResource , FabricanteResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.produto = new ProdutoResource(self.original);
            FabricanteResource.queryAll(function(items) {
                $scope.fabricanteSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.produto.fabricante){
                        $.each($scope.produto.fabricante, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.fabricanteSelection.push(labelObject);
                                $scope.produto.fabricante.push(wrappedObject);
                            }
                        });
                        self.original.fabricante = $scope.produto.fabricante;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Produtos");
        };
        ProdutoResource.get({ProdutoId:$routeParams.ProdutoId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.produto);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.produto.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Produtos");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Produtos");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.produto.$remove(successCallback, errorCallback);
    };
    
    $scope.fabricanteSelection = $scope.fabricanteSelection || [];
    $scope.$watch("fabricanteSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.produto) {
            $scope.produto.fabricante = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.produto.fabricante.push(collectionItem);
            });
        }
    });
    
    $scope.get();
});