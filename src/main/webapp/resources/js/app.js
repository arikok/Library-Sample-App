(function() {

	var app = angular.module("library", []);

	var mainController = function($scope, $http) {
		$scope.book = {};
		$scope.books = null;
		$scope.ajaxProcess = 0;
		$scope.errorAuthor = false;
		$scope.errorCaptcha = false;
		$scope.errorBookName = false;

		$http.get('/book').success(function(data, status, headers, config) {

			$scope.books = data;
		});

		$scope.sendBook = function() {

			$scope.book.gResponse = document
					.getElementById('g-recaptcha-response').value;

			$scope.ajaxError = 0;
			if ($scope.validateInput()) {
				$scope.ajaxSendProcess = 1;
				$http({
					method : 'POST',
					url : '/book',
					data : $scope.book,
					headers : {
						'Content-Type' : 'application/json'
					}

				}).success(function(data) {
					$scope.ajaxSendProcess = 2;				

				}).error(function(data) {
					$scope.ajaxError = 1;
					$scope.ajaxSendProcess = 0;					
				});

			}

		};

		$scope.showModal = function() {

			inputPanel.show();

		};

		$scope.refreshBooks = function() {

			$scope.ajaxRefreshProcess = 1;
			$http.get('/book').success(function(data, status, headers, config) {

				$scope.books = data;
				$scope.ajaxRefreshProcess = 0;
			});

		}

		$scope.validateInput = function() {

			var isValid = true;
			$scope.errorAuthor = false;
			$scope.errorCaptcha = false;
			$scope.errorBookName = false;

			if ($scope.book.author == null || $scope.book.author == "") {
				isValid = false;
				$scope.errorAuthor = true;
			}

			if ($scope.book.bookName == null || $scope.book.bookName == "") {

				isValid = false;
				$scope.errorBookName = true;

			}

			if ($scope.showCaptcha) {
				var captchaValue = document
						.getElementById('g-recaptcha-response').value;
				if (captchaValue == null || captchaValue == "") {
					isValid = false;
					$scope.errorCaptcha = true;
				}
			}

			return isValid;
		}

	}

	app.controller("mainController", mainController);

}())
