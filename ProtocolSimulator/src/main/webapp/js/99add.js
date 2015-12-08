/**
 * Created by huanliu on 2015/9/9.
 */
$(function(){

    var add={
        init:function(){
            //加油卡卡密发货接口
            $("#submit_btn_delivery").click(function(){
                addDelivery();
            });
            //订单查询接口
            $("#submit_btn_QueryOrder").click(function(){
                //alert("成功.");
                addQueryOrder();
            });
        }
    }


    //加油卡卡密发货接口
    function addDelivery(){
        $("#form_delivery :input.required").trigger('blur');
        var numError = $('#form_delivery .onError').length;
        if(numError){
            //alert('请填写完整表单必填数据！');
            //return ;
        }


        $("#submit_btn_delivery").html("提交中");
        $("#submit_btn_delivery").css("background","rgb(170, 200, 233)");
        $("#submit_btn_delivery").attr("disabled",true);//提交过程中不能再次发起请求

        $("#textare_delivery").val('');//返回信息区域清空
        var urlprotocol=$("#urlprotocol").val();
        var url=$("#url").val();
        var key=$("#key").val();
        var params='url='+urlprotocol+url+"&key="+key+"&"+$('#form_delivery').serialize();

        $.ajax({
                type: "POST",
                url: "/ProtocolSimulator/simulator/delivery",
                data: params,
                dataType:"html",
                success: function(msg){
                    $("#submit_btn_delivery").html("提交成功");
                    $("#submit_btn_delivery").css("background","#7fa9d5");
                    $("#submit_btn_delivery").removeAttr("disabled");
                    $("#textare_delivery").val(msg);
                },
                error:function(msg){
                    $("#submit_btn_delivery").html("提交失败");
                    $("#submit_btn_delivery").css("background","#7fa9d5");
                    $("#submit_btn_delivery").removeAttr("disabled");
                    $("#textare_delivery").val(msg);
                    console.log(msg);
                }

            });

    }
    
    
    //订单查询接口
    function  addQueryOrder(){
        $("#form_queryOrder :input.required").trigger('blur');
        var numError = $('#form_queryOrder .onError').length;
        if(numError){
            //alert('请填写完整表单数据');
            //return ;
        }


        $("#submit_btn_QueryOrder").html("提交中");
        $("#submit_btn_QueryOrder").css("background","rgb(170, 200, 233)");
        $("#submit_btn_QueryOrder").attr("disabled",true);//提交过程中不能再次发起请求


        $("textare_QueryOrder").val("");//返回信息区域清空
        var urlprotocol=$("#urlprotocol").val();
        var url=$("#url").val();
        var key=$("#key").val();
        var params='url='+urlprotocol+url+"&key="+key+"&"+$('#form_queryOrder').serialize();
        
        $.ajax({
            type: "POST",
            url: "/ProtocolSimulator/simulator/queryOrder",
            data: params,
            dataType:"html",
            success: function(msg){
                $("#submit_btn_QueryOrder").html("提交成功");
                $("#submit_btn_QueryOrder").css("background","#7fa9d5");
                $("#submit_btn_QueryOrder").removeAttr("disabled");
                $("#textare_QueryOrder").val(msg);

            },
            error:function(msg){
                $("#submit_btn_QueryOrder").html("提交失败");
                $("#submit_btn_QueryOrder").css("background","#7fa9d5");
                $("#submit_btn_QueryOrder").removeAttr("disabled");
                $("#textare_QueryOrder").val(msg);
                console.log(msg);
            }

        });
    }

    $(document).ready(function(){
        add.init();
    });

})