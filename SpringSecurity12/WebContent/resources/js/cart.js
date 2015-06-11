$(document).ready(function() {
	
	var cartId;
	
	addToCart = function(productId){
			$.ajax({
		 		url: '/SpringSecurity12/rest/cart/add/' + productId,
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
				url: '/SpringSecurity12/rest/cart/remove/'+ productId,
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
					url: '/SpringSecurity12/rest/cart/getId/',
					type: 'GET',
					success : function(id) {
					 		 		 cartId = id;
					 	 		}
			});
		 }

		 refreshCart = function() {
				$.ajax({
					url: '/SpringSecurity12/rest/cart/'+ cartId,
					type: 'GET',
					dataType: "json",
					success : function(cartData) {
 		 		 		location.reload(true);
 	 
					 }
			});
		 }

});

 