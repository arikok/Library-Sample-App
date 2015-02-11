<!DOCTYPE html>
<html ng-app="library">

<head>
<title>Library</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src='//www.google.com/recaptcha/api.js'></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.11/angular.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.11/angular-route.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.11/angular-resource.js"></script>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/angular-no-captcha.js"></script>

</head>
<body ng-controller="mainController">
	<div class="container">

		<div class="row">
			<div class="col-md-4" style="margin: 20px">
				<a id="modalTrigger" href="#modal-container-new" role="button"
					class="btn btn-primary"
					ng-click="book={};showCaptcha=true;ajaxSendProcess=0;ajaxError=0"
					data-toggle="modal">Kitap Ekle</a>
			</div>
			<img ng-show="ajaxRefreshProcess==1"
				src="${pageContext.request.contextPath}/resources/img/LoadingWheel2.gif">
			<div class="col-md-4" style="margin: 20px">
				<a id="modalTrigger" role="button" class="btn btn-primary"
					ng-click="refreshBooks()">Yenile</a>
			</div>

		</div>

		<div class="row" ng-show="!books.length">
			<span>Kütüphaneye Kitap Ekleyin</span>
		</div>

		<div class="row clearfix" ng-repeat="rBook in books"
			ng-click="$parent.book=rBook;$parent.showCaptcha=false;$parent.ajaxSendProcess=0;$parent.ajaxError=0"
			href="#modal-container-new" data-toggle="modal">

			<div class="col-md-8 column">

				<div class="alert alert-info" role="alert">{{rBook.author}} -
					{{rBook.bookName}}</div>
			</div>

		</div>

	</div>

	<div class="modal fade" id="modal-container-new">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title" id="myModalLabel">Kitap</h4>
				</div>
				<div class="modal-body">

					<form role="form" ng-submit="sendBook()">
						<div class="alert alert-danger" role="alert" ng-show="errorAuthor">
							<span class="glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span> <span class="sr-only">Error:</span>
							Bir Yazar Girin
						</div>
						<div class="form-group">
							<label for="inputAuthor">Yazar</label><input type="text"
								class="form-control" id="inputAuthor" ng-model="book.author" />
						</div>
						<div class="alert alert-danger" role="alert"
							ng-show="errorBookName">
							<span class="glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span> <span class="sr-only">Error:</span>
							Kitap Adını Girin
						</div>
						<div class="form-group">
							<label for="inputBookName">Kitap Adı</label><input type="text"
								class="form-control" id="inputBookName" ng-model="book.bookName" />
						</div>
						<div class="alert alert-danger" role="alert"
							ng-show="errorCaptcha">
							<span class="glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span> <span class="sr-only">Error:</span>
							Doğrulamayı Tamamlayın
						</div>
						<div ng-show="showCaptcha">
							<div class="g-recaptcha"
								data-sitekey="6Lej2_4SAAAAAPpd25lQo1j4nCLbUVAiO4FuWUD2"></div>

						</div>

						<img ng-show="ajaxSendProcess==1"
							src="${pageContext.request.contextPath}/resources/img/LoadingWheel2.gif">
						<span ng-show="ajaxSendProcess==2">Kayıt işlemi tamamlandı.</span>
						<span ng-show="ajaxError==1">Bir Hata Gerçekleşti.</span>
						<button type="submit" class="btn btn-primary">Kaydet</button>
					</form>

				</div>
				<div class="modal-footer"></div>
			</div>

		</div>

	</div>




</body>
</html>