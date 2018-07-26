<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href="../dashboard/fullcalendar.css" rel='stylesheet' />
<link href="../dashboard/fullcalendar.print.css" rel='stylesheet' media='print' />
 <script src="../dashboard/libs/jquery.min.js"></script>
<script src="../dashboard/libs/moment.min.js"></script>

<script src="../dashboard/fullcalendar.min.js"></script>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
<script type="text/javascript">
function aj()
{
	alert("ajax success...");
	document.getElementById("event").innerHTML = "<h2>helloone</h2>";
}







</script>
</head>
<body>

<!-- 
<div id="event"> -->
<script>

$(document).ready(function() {

    var calendar = $('#calendar').fullCalendar({
    
    editable: true,
      selectable: true,
    //header and other values
    select: function() {
    //	alert("ngfkdj");
       endtime = $.fullCalendar.formatDate(end,'h:mm tt');
        starttime = $.fullCalendar.formatDate(start,'ddd, MMM d, h:mm tt');
        var mywhen = starttime + ' - ' + endtime;
        $('#createEventModal #apptStartTime').val(start);
        $('#createEventModal #apptEndTime').val(end);
        $('#createEventModal #apptAllDay').val(allDay);
        $('#createEventModal #when').text(mywhen); 
        $('#createEventModal').modal('show');
     }
  });

$('#submitButton').on('click', function(e){
  // We don't want this to act as a link so cancel the link action
  e.preventDefault();

  doSubmit();
});

function doSubmit(){
  $("#createEventModal").modal('hide');
  console.log($('#apptStartTime').val());
  console.log($('#apptEndTime').val());
  console.log($('#apptAllDay').val());
  alert("form submitted");
      
  $("#calendar").fullCalendar('renderEvent',
      {
          title: $('#patientName').val(),
          start: new Date($('#apptStartTime').val()),
          end: new Date($('#apptEndTime').val()),
          allDay: ($('#apptAllDay').val() == "true"),
      },
      true);
 }
});




/* 

	$(document).ready(function() {
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			defaultDate: '2016-01-12',
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			selectable: true,
			
			select:function(){
				var o="hjvb";
				 $('#g1 #when').text(o);
			}
			
			/* events: [
				{
					title: 'All Day Event',
					start: '2016-01-01'
				},
				{
					title: 'Long Event',
					start: '2016-01-07',
					end: '2016-01-10'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2016-01-09T16:00:00'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2016-01-16T16:00:00'
				},
				{
					title: 'Conference',
					start: '2016-01-11',
					end: '2016-01-13'
				},
				{
					title: 'Meeting',
					start: '2016-01-12T10:30:00',
					end: '2016-01-12T12:30:00'
				},
				{
					title: 'Lunch',
					start: '2016-01-12T12:00:00'
				},
				{
					title: 'Meeting',
					start: '2016-01-12T14:30:00'
				},
				{
					title: 'Happy Hour',
					start: '2016-01-12T17:30:00'
				},
				{
					title: 'Dinner',
					start: '2016-01-12T20:00:00'
				},
				{
					title: 'Birthday Party',
					start: '2016-01-13T07:00:00'
				},
				{
					title: 'Click for Google',
					url: 'http://google.com/',
					start: '2016-01-28'
				}
			] 
			
		});
		
	}); */
	
</script> 
<div id="calendar"></div>

<div id="createEventModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3 id="myModalLabel1">Create Appointment</h3>
    </div>
    <div class="modal-body">
    <form id="createAppointmentForm" class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="inputPatient">Patient:</label>
            <div class="controls">
                <input type="text" name="patientName" id="patientName" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="[&quot;Value 1&quot;,&quot;Value 2&quot;,&quot;Value 3&quot;]">
                  <input type="hidden" id="apptStartTime"/>
                  <input type="hidden" id="apptEndTime"/>
                  <input type="hidden" id="apptAllDay" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="when">When:</label>
            <div class="controls controls-row" id="when" style="margin-top:5px;">
            </div>
        </div>
    </form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button type="submit" class="btn btn-primary" id="submitButton">Save</button>
    </div>
</div> 






<!-- <div id="createEventModal">
  

  Modal
  <div class="modal hide" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div> -->
  



</body>
</html>
