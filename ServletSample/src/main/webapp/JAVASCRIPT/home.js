/**
 * 
 */
getData();
function getData(){
	$.ajax({
	    url:'../home',
	    dataType:'json',
	    type:'get',
	    async:false,
	    success: function (data) {
	        drawSearchResponse(data)
	    },
	    error: function (textStatus, errorThrown) {
	    	drawSearchResponse("Error getting the data")
	    }

	 });

}
function drawSearchResponse(data){
	for(let i=0;i<data.covidCaseDataBO.length;i++){
		$('#temp').append('<h3>'+data.covidCaseDataBO[i].caseCount+'</h3>');
		$('#temp').append('<h3>'+data.covidCaseDataBO[i].monthValues+'</h3>');
	}
	console.log(data);
}