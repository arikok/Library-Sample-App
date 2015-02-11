var bookPanel;
panel = panel || (function () {
    var pleaseWaitDiv = $('<div class="modal fade" id="staticLoadingPanel" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">' +
				    		  '<div class="modal-dialog" style="height:100%">'+
				    		    '<div class="modal-content" style="position: relative;top: 50%;margin-top: -100px;height: 193px">'+
				    		      '<div class="modal-header">'+
				    		        '<h4 id="staticLoadingPanel_title" class="modal-title">Lütfen Bekleyiniz...</h4>'+ 
				    		      '</div>'+
				    		      '<div class="modal-body center-block">'+
				    		        '<div class="progress progress-striped active">'+
				    		          '<div id="staticLoadingPanel_progress" class="progress-bar"  role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">'+
				    		          '</div>'+
				    		        '</div>'+
				    		      '</div>'+
				    		      '<div class="modal-footer"></div>'+
				    		    '</div>'+
				    		  '</div>'+
				    		'</div>');
    return {
        showPleaseWait: function() {
            pleaseWaitDiv.modal();
        },
        hidePleaseWait: function () {
            pleaseWaitDiv.modal('hide');
        },
        setTitle: function(title){
        	$(pleaseWaitDiv).find('#staticLoadingPanel_title').text(title);
        },
        setPercentValue: function(value){
        	$(pleaseWaitDiv).find('#staticLoadingPanel_progress').css('width', value + '%');
        }
    };
})();