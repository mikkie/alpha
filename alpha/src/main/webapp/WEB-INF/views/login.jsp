<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="../include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Login</title>
  <!-- Bootstrap core CSS -->
  <link href="${ctx}/static/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
  <script type="text/javascript" src="${ctx}/static/angularJS/angular.min.js"></script>
  <%@ include file="../include/common.jsp"%>
  <!-- Custom styles for this template -->
  <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
  <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
    </head>
    <body>
      <div class="container" ng-app="loginPage">
        <div class="row">
          <div class="col-md-4 col-md-offset-4">
            <form class="form-signin" ng-controller="loginCtrl" name="loginForm">
              <h2 class="form-signin-heading">Please sign in</h2>
              <label for="inputEmail" class="sr-only">Email address</label>
              <input type="text" id="name" class="form-control" placeholder="Name" ng-model="name" required autofocus>
              <label for="inputPassword" class="sr-only">Password</label>
              <input type="password" id="password" class="form-control" placeholder="Password" ng-model="password" required>
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me"> Remember me
                </label>
              </div>
              <span style="color:red;">{{error}}</span>
              <button class="btn btn-lg btn-primary btn-block" type="button" ng-click="login();">Sign in</button>
            </form>
          </div>
        </div>
      </div> <!-- /container -->
      <script type="text/javascript">
         var app = angular.module('loginPage',[],configHttpPost);
         app.controller('loginCtrl',function($scope,$http) {
             $scope.login = function(){
               $scope.error = '';
               if(!$scope.name){
                  $scope.error = '请输入用户名';
                  return false;
               }
               if(!$scope.password){
                  $scope.error = '请输入密码';
                  return false;
               }
               $http.post(ctx + '/login/do', {name:$scope.name,password:$scope.password}).
               success(function(data, status, headers, config) {
                  if(data.error){
                    $scope.error = data.error;
                  }
                  else{
                    location.href = ctx + '/index'
                  }
               }).error(function(data, status, headers, config) {
                  $scope.error = '服务不可用，稍后重试';
               });
             };
         });
      </script>
    </body>
    </html>
