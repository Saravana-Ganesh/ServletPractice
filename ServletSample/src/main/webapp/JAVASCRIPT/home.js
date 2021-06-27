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
	//var xValues = [100,200,300,400,500,600,700,800,900,1000];
	var xValues = [];
	var caseCountData = [];
	for(let i=0;i<data.covidCaseDataBO.length;i++){
		xValues.push(data.covidCaseDataBO[i].monthValues);
		caseCountData.push(data.covidCaseDataBO[i].caseCount);
	}
	console.log(data);
	//var xValues = [100,200,300,400,500,600,700,800,900,1000];

	new Chart("myChart", {
	  type: "line",
	  data: {
	    labels: xValues,
	    datasets: [{ 
	      data: caseCountData,//[860,1140,1060,1060,1070,1110,1330,2210,7830,2478],
	      borderColor: "blue",
	      fill: false
	    }/*, { 
	      data: [1600,1700,1700,1900,2000,2700,4000,5000,6000,7000],
	      borderColor: "green",
	      fill: false
	    }, { 
	      data: [300,700,2000,5000,6000,4000,2000,1000,200,100],
	      borderColor: "blue",
	      fill: false
	    }*/]
	  },
	  options: {
	    legend: {display: false}
	  }
	});
}