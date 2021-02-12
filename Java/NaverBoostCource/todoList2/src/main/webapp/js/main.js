function draw(type, eventNode) {
	var insertItem = eventNode.parentNode;
	if (type == "TODO") {
		type = 'DOING';
	} else if (type == "DOING") {
		type = 'DONE';
	}
	var list = document.querySelector("section[id=" + type + "]");

	list.appendChild(insertItem);
}

function backdraw(type, eventNode) {
	var insertItem = eventNode.parentNode;

	if (type == "DOING") {
		type = 'TODO';
	} else if (type == "DONE") {
		type = 'DOING';
	}
	var list = document.querySelector("section[id=" + type + "]");

	list.appendChild(insertItem);
}

function backButtonClick(id, eventNode) {
	var httpRequest = new XMLHttpRequest();
	var type = eventNode.parentNode.parentNode.getAttribute("id");

	httpRequest.addEventListener("load", function() {
		if (this.responseText === "success")
			backdraw(type, eventNode);
	});

	httpRequest.open("GET", "./ReturnTypeServlet?id=" + id + "&type=" + type);
	httpRequest.send();
}

function changeButtonClick(id, eventNode) {
	var httpRequest = new XMLHttpRequest();
	var type = eventNode.parentNode.parentNode.getAttribute("id");

	httpRequest.addEventListener("load", function() {
		if (this.responseText === "success")
			draw(type, eventNode);
	});

	httpRequest.open("GET", "./TodoTypeServlet?id=" + id + "&type=" + type);
	httpRequest.send();
}