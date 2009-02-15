<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<p>Persons</p>
<s:if test="persons.size > 0">
	<table>
		<s:iterator value="persons">
			<tr id="row_<s:property value="id"/>">
				<td>
					<s:property value="firstName" />
				</td>
				<td>
					<s:property value="lastName" />
				</td>
				<td>
					<s:url id="removeUrl" action="remove">
						<s:param name="id" value="id" />
					</s:url>
					<s:a href="%{removeUrl}" theme="ajax" targets="persons">Remove</s:a>
					<s:a id="a_%{id}" theme="ajax" notifyTopics="/edit">Edit</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>

