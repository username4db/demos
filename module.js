function getJSON(url, callback) {
	let xhr = new XMLHttpRequest();
	xhr.onload = function () {
		callback(this.responseText)
	};
	xhr.open('GET', url, true);
	xhr.send();
}

export function getUsefulContents(url, callback) {
	getJSON(url, function (data) {
		callback(data);
	});
}

export function get3() {
	console.log(3);
	return 3;
}
