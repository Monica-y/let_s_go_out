function addShoppingCart() {
    $("#status").val("false");
}

function buyGood() {
    $("#status").val("true");
}

function isBuyVaild() {

    if ($("#status").val() == 'true'){
        alert("购买成功！");
        return true;
    }
    if($("#status").val() == 'false'){
        alert("添加购物车成功！" );
        return true;
    }

    return false;
}

function add(total) {
    var number=parseInt($("#number").val());
    if(number==10||parseInt(total)<=10)
        return;
    $("#number").val(number+1);
}

function subtract() {
    var number=parseInt($("#number").val());
    if(number==1)
        return;
    $("#number").val(number-1);
}

