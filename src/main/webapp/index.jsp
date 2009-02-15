<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<s:head theme="ajax" debug="true"/>
		<script type="text/javascript">
			dojo.event.topic.subscribe("/save", function(data, type, request) {
			    if(type == "load") {
					dojo.byId("id").value = "";
					dojo.byId("firstName").value = "";
					dojo.byId("lastName").value = "";
				}
			});

			dojo.event.topic.subscribe("/edit", function(data, type, request) {
			    if(type == "before") {
					var id = data.split("_")[1];

					var tr = dojo.byId("row_"+id);
					var tds = tr.getElementsByTagName("td");

					dojo.byId("id").value = id;
					dojo.byId("firstName").value = dojo.string.trim(dojo.dom.textContent(tds[0]));
					dojo.byId("lastName").value = dojo.string.trim(dojo.dom.textContent(tds[1]));
				}
			});
		</script>
	</head>
	<body>
	    <s:url action="list" id="descrsUrl"/>

        <div style="width: 300px;border-style: solid">
        	<div style="text-align: right;">
    			<s:a theme="ajax" notifyTopics="/refresh">Refresh</s:a>
    		</div>
    		<s:div id="persons" theme="ajax" href="%{descrsUrl}" loadingText="Loading..." listenTopics="/refresh"/>
        </div>

        <br/>

		<div style="width: 300px;border-style: solid">
			<p>Person Data</p>
			<s:form action="save" validate="true">
			    <s:textfield id="id" name="person.id" cssStyle="display:none"/>
				<s:textfield id="firstName" label="First Name" name="person.firstName"/>
				<s:textfield id="lastName" label="Last Name" name="person.lastName"/>
				<s:submit theme="ajax" targets="persons" notifyTopics="/save"/>
			</s:form>
		</div>
	</body>
</html>

