var num=0;
function loop() {
	++num;
	postMessage("test: "+num);
	setTimeout("loop()",1000);
}
loop();