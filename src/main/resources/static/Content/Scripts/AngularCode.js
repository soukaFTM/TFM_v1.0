//var app = angular.module("myApp", ['angularUtils.directives.dirPagination']);
var app = angular.module("AdherentApp", []);
app.controller("AdherentCtrl", function ($scope, $http) {
    debugger;
    $scope.sort = function (keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    }
    $scope.GetAllData = function () {
        $http.get('http://localhost:51554/Adherents/Get_AllAdherents')
         .then(function (response) {
             $scope.Adherents = response.data;
         }, function () {
             alert("Error Occur 1");
         })
    };
    
    $scope.DeleteAdh = function (Adh) {
       // alert('in');
       $http({
            method: "post",
            url: "/Adherents/Delete_Adh",
            datatype: "json",
            data: JSON.stringify(Adh)
        }).then(function (response) {
            alert(response.data);
            $scope.GetAllData();
        })
    };

})

var appCredit = angular.module("CreditApp", []);
appCredit.controller("CreditCtrl", function ($scope, $http) {
    debugger;
    $scope.InsertData = function () {
        var Action = document.getElementById("btnSave").getAttribute("value");
        if (Action == "Submit") {
            $scope.Codification = {};
            $scope.Codification.code = $scope.code;
            $scope.Codification.LibelleAr = $scope.LibelleAr;
            $scope.Codification.LibelleFr = $scope.LibelleFr;
            $scope.Codification.Table = $scope.Table;
            $http({
                method: "post",
                url: "/Codification/Insert_Codification",
                datatype: "json",
                data: JSON.stringify($scope.Codification)
            }).then(function (response) {
                alert(response.data);
                $scope.GetAllData();
                $scope.Code = "";
                $scope.LibelleAr = "";
                $scope.LibelleFr = "";
                $scope.Table = "";
            })
        } else {
            $scope.Codification = {};
            $scope.Codification.code = $scope.code;
            $scope.Codification.LibelleAr = $scope.LibelleAr;
            $scope.Codification.LibelleFr = $scope.LibelleFr;
            $scope.Codification.Table = $scope.Table;
            $scope.Codification.IdCodification = document.getElementById("CodiID_").value;
            $http({
                method: "post",
                url: "/Codification/Update_Codification",
                datatype: "json",
                data: JSON.stringify($scope.Codification)
            }).then(function (response) {
                alert(response.data);
                $scope.GetAllData();
                $scope.code = "";
                $scope.LibelleAr = "";
                $scope.LibelleFr = "";
                $scope.Table = "";
                document.getElementById("btnSave").setAttribute("value", "Submit");
                document.getElementById("btnSave").style.backgroundColor = "deepskyblue";
                document.getElementById("spn").innerHTML = "Nouvelle Codification";
            })
        }
    }
    $scope.GetAllData = function () {
        $http.get('/Codification/Get_AllCodification')
        .then(function (response) {
            $scope.Codifications = response.data;
        }, function () {
            alert("Error Occur 1");
        })
    };
    $scope.DeleteCod = function (Cod) {
        $http({
            method: "post",
            url: "/Codificatione/Delete_Codificatione",
            datatype: "json",
            data: JSON.stringify(Cod)
        }).then(function (response) {
            alert(response.data);
            $scope.GetAllData();
        })
    };
    $scope.UpdateCod = function (Cod) {
        document.getElementById("CodID_").value = Cod.Cod_Id;
        $scope.code = Cod.code;
        $scope.CodCity = Cod.Cod_City;
        $scope.CodAge = Cod.Cod_Age;
        document.getElementById("btnSave").setAttribute("value", "Update");
        document.getElementById("btnSave").style.backgroundColor = "Pink";
        document.getElementById("spn").innerHTML = "Modification des information";
    }
})