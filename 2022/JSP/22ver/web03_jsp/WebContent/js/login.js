function sendData(){
	
	var f = document.frm;
	
	if( f.id.value == "" ) {
		window.alert("id는 필수 사항입니다.");
		f.id.focus();
		return false;
	}
	if( f.id.value.length < 4 || f.id.value.length > 20 ) {
		window.alert("id는 4자 이상 20자 이하입니다.");
		f.id.focus();
		return false;
	}
	
	if( f.pwd.value == "" ) {
		window.alert("pwd는 필수 사항입니다.");
		f.pwd.focus();   // 커서를 맞춰줌
		return false;
	}
	if( f.pwd.value.length < 4 || f.pwd.value.length > 8 ) {
		window.alert("id는 4자 이상 8자 이하입니다.");
		f.pwd.select();  //커서를 맞춰줌 - 이전 데이터를 지우지 않고 포커스...
		return false;
	}
}