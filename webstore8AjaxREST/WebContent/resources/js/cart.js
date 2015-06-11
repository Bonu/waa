$(document).ready(function() {
	
	var cartId;
	
	getCategoriesAJAX = function(){
		var selectedValue = $("#manufacturer").val();
		alert(selectedValue)
		$.ajax({
			type:'GET',
			url: '/webstore8AjaxREST/getcategory/'+selectedValue,
	 		data: "manufacturer="+manufacturer,
			success: function(data,status,jqXHR){
 		 		alert(data);
 		 		var arr = data;
 		 		alert(arr);
 		 		var select = $('#category');
 		 		select.find('option').remove();
 		 		$.each( arr, function(index, value ) {
 		 			$('<option>').val(value).text(value).appendTo(select);
 		 		});
			},
			error: function(jqXHR, status){						
				alert('Error while request categories..'+status);
			}
		});
	}

	
	addToCart = function(productId){
			$.ajax({
		 		url: '/webstore8AjaxREST/rest/cart/add/' + productId,
		 		type: 'PUT',
				success: function(response){
	 		 		alert("Product Successfully added to the Cart!");

				},
				error: function(){						
					alert('Error while request..');
				}
			});
		}

	   removeFromCart = function(productId) {
			$.ajax({
				url: '/webstore8AjaxREST/rest/cart/remove/'+ productId,
		 		type: 'PUT',
			 	 success: function (response) {
 
		 		 		location.reload(true);

					},
					error: function(){						
						alert('Error while request..');
			 	 } 
		   });
	   }

		 getCartId = function( ) {
				$.ajax({
					url: '/webstore8AjaxREST/rest/cart/getId/',
					type: 'GET',
					success : function(id) {
					 		 		 cartId = id;
					 	 		}
			});
		 }

		 refreshCart = function() {
				$.ajax({
					url: '/webstore8AjaxREST/rest/cart/'+ cartId,
					type: 'GET',
					dataType: "json",
					success : function(cartData) {
 		 		 		location.reload(true);
 	 
					 }
			});
		 }

});

 