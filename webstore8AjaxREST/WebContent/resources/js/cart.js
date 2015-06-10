$(document).ready(function() {
	
	var cartId;
	
	getCategoriesAJAX = function(manufacturer){
		$.ajax({
	 		url: '/webstore8AjaxREST/products/getcategory/',
	 		data: "manufacturer="+manufacturer,
	 		type: 'PUT',
			success: function(response){
 		 		alert("Received the categories Successfully !");
 		 		for(i =0 ; i < response.result.length ; i++){
 		 			    userInfo += "<br><li><b>Name</b> : " + response.result[i].name +
 		 			                    ";<b> Education</b> : " + response.result[i].education;
 		 			  }


			},
			error: function(){						
				alert('Error while request categories..');
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

 