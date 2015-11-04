angular.module('ecommerce').factory('FabricanteResource', function($resource){
    var resource = $resource('rest/fabricantes/:FabricanteId',{FabricanteId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});