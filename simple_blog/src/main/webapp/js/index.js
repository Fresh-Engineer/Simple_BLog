function wordStatic(input) {
    var content = $('#wordsLength').val();
    var value = $('#blog').val();

    if (content&&input) {
        value = value.replace(/[\n\r]/gi, "");
        content.innerText = value.length+"/80";
    }else {
        content.innerText = "0/80";
    }
}


function clearTextArea() {
    var content = document.getElementById('wordsLength')
    content.innerText = "0/80";
}


function answer(){

}

