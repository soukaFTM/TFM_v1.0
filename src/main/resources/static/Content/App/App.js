var app=angular.module("MyApp",[]);



app.controller("ProduitController",function($scope,$http){
	
	
	//// recupere //////
	$scope.pageProduits=null;
	$scope.getAllProduits=function(){
		$http.get("http://localhost:8080/produits")
		.then(function(response){
			$scope.pageProduits=response.data;
		},function(err) {
			consol.log(err);
		});  
	}
	
   
	/// sauvgarder ////
	$scope.SaveProduit=function(){
		if($scope.typeProduit=="PA")
			$scope.URL="http://localhost:8080/saveProduitPA";
		if($scope.typeProduit=="SV")
			$scope.URL="http://localhost:8080/saveProduitSV";
		if($scope.typeProduit=="AD")
			$scope.URL="http://localhost:8080/saveProduitAD";
		if($scope.typeProduit=="OTH")
			$scope.URL="http://localhost:8080/saveProduitOTH";				
		$http({
            method: "post",
            url: $scope.URL,
            datatype: "json",
            data: $scope.produit,
            header: {"Content-type":"application/json"}
        })
		.then(function(response){
			$scope.getAllProduits(); 
			$scope.produit=null;
			$scope.typeProduit="";
		},function(err) {
			$consol.log(err);
		});  
	}
	
	/// MODIFIER ////////
	$scope.GetUpdateProduit = function (produit) {
        $scope.produit=produit;
        document.getElementById("btnSave").setAttribute("value", "Modifier");
       // document.getElementById("btnSave").style.backgroundColor = "Pink";
      //  document.getElementById("spn").innerHTML = "Modification des information";
    }
	
	$scope.UpdateProduit = function (produit) {
		alert($scope.produit.numProduit);
		$http({
            method: "put",
            url: "http://localhost:8080/updateProduits/"+$scope.produit.numProduit,
            datatype: "json",
            data: $scope.produit,
            header: {"Content-type":"application/json"}
        }).then(function (response) {
        	$scope.getAllProduits(); 
			$scope.produit=null;
			$scope.typeProduit="";
            document.getElementById("btnSave").setAttribute("value", "Sauvgarder");
          //  document.getElementById("btnSave").style.backgroundColor = "deepskyblue";
          //  document.getElementById("spn").innerHTML = "Nouveau Empolye";
        })
    }
	
	 $scope.gestionProduit = function () {
	        var Action = document.getElementById("btnSave").getAttribute("value");
	        if (Action == "Sauvgarder") {
	        	$scope.SaveProduit();
	        } else {
	            $scope.UpdateProduit();
	        }
	    }
	    
});


app.controller("PromotionController",function($scope,$http){
	$scope.show=false;
	$scope.prodDetail=null;
	//// recupere //////
	$scope.promotions=null;
	$scope.getAllPromotions=function(){
		$http.get("http://localhost:8080/promotions")
		.then(function(response){
			$scope.promotions=response.data._embedded.promotions;
		},function(err) {
			consol.log(err);
		});  
		
		
	}
	
	$scope.ShowPromotionProduits=function(p)
	{
		$scope.prodDetail=p;

	}
	
	$scope.pageProduits=null;
	$scope.getAllProduits=function(){
		$http.get("http://localhost:8080/produits")
		.then(function(response){
			$scope.pageProduits=response.data;
		},function(err) {
			consol.log(err);
		});  
	}
	
	$scope.ChosenProduit= [];
	$scope.promotion=null;
	$scope.SavePromotion=function(){
			$scope.promotion.listeProduit=$scope.ChosenProduit;		
		$http({
            method: "post",
            url: "http://localhost:8080/promotions",
            datatype: "json",
            data: $scope.promotion,
            header: {"Content-type":"application/json"}
        })
		.then(function(response){
			//$scope.getAllProduits(); 
			$scope.promotion=null;
		},function(err) {
			$consol.log(err);
		});  
	}
	
});