/**
 * Created by huanliu on 2015/9/10.
 */


    //文本框默认提示文字
    //function textFocus(el) {
    //    if (el.defaultValue == el.value) { el.value = ''; el.style.color = '#333'; }
    //}
    //function textBlur(el) {
    //    if (el.value == '') { el.value = el.defaultValue; el.style.color = '#999'; }
    //}

    $(function(){

        //加油卡充值接口 (sinopec/delivery)  tab2
        $('#form_delivery :input').blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            //验证用户名
            if( $(this).is('#merId') ){
                if( this.value==""  ){
                    var errorMsg = '请输入商户id.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }

            //验证密码
            if( $(this).is('#merPwd') ){
                if( this.value==""  ){
                    var errorMsg = '请输入商户密码.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }


            //验证产品ID
            if( $(this).is('#cardId') ){
                if( this.value==""  ){
                    var errorMsg = '请输入产品ID.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }

            //验证订购数量  单次限制(1-10)
            if( $(this).is('#num') ){
                var reg=/^([1-9]|10)$/;
                var val= $.trim($(this).val());
                var len=val.length;
                if(len>2){
                    var str=val.substr(0,2);
                    $(this).val(str);
                }

                if( this.value=="" || !reg.test($(this).val()) ){
                    var errorMsg = '单次限制(1-10) .';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }

            //验证客户端订单流水号
            if( $(this).is('#orderId') ){
                if( this.value==""  ){
                    var errorMsg = '请输入订单流水号 .';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }


            //验证订单时间
            if( $(this).is('#orderTime') ){
                if( this.value==""  ){
                    var errorMsg = '请输入订单订单时间 .';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }



            //验证持卡人手机号
            if( $(this).is('#gasCardTel') ){
               // /^0?1[3|4|5|8][0-9]\d{8}$/
                var reg2= /^0?1[3|4|5|8][0-9]\d{8}$/;


                var val2= $.trim($(this).val());
                $(this).val(val2);
                var len2=val2.length;
                if(len2==1&&val2==0){
                    $(this).val("");
                }
                if(len2>11){
                    var str2=val2.substr(0,11);
                    $(this).val(str2);
                }

                if( this.value=="" || !reg2.test($(this).val()) || $.trim( this.value).length<11){
                    var errorMsg = '请输入持卡人手机号.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }


            //验证持卡人姓名
            //if( $(this).is('#gasCardName') ){
                //if( this.value==""  ){
                    //var errorMsg = '请输入持卡人姓名.';
                    //alert("值为："+$(this).val());
                    //$parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                //}else{
                    //var okMsg = '输入正确.';
                    //$parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                //}
            //}


            ////验证是否需要卡密使用结果状态 选填,0-否,1-是,(默认0)
            //if( $(this).is('#isNotifyResult') ){
                //if( this.value==""  ){
                //    var errorMsg = '请输入持卡人姓名.';
                //    //alert("值为："+$(this).val());
                //    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                //}else{
                //    var okMsg = '输入正确.';
                //    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                //}
            //}



            //验证接受卡密使用结果地址  选填(isNotifyResult=1,必填)
            $('input:radio[name=isNotifyResult]').click(function(){
                  var result=$(this).val();
                    if(result==0){
                        $(".address").hide();
                        $("#notify_url").removeClass("required");
                    }else{
                        $(".address").show();
                        $("#notify_url").addClass("required");
                    };
            });



            if( $(this).is('#notify_url') ){
                if( this.value==""  ){
                    var errorMsg = '请输入结果地址.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }

            //验证版本号
            if( $(this).is('#version') ){
                if( this.value==""  ){
                    var errorMsg = '请输入版本号.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }


        }).keyup(function(){
            $(this).triggerHandler("blur");
        }).focus(function(){
            $(this).triggerHandler("blur");
        });//end blur


        //重置
        $('#form_delivery #res').click(function(){
            $(".formtips").remove();
            $('form :input').val("");
        });



        //订单查询接口(queryOrder)    tab3 表单form_queryOrder下数据验证
        //文本框失去焦点后
        $('#form_queryOrder :input').blur(function(){
            var $parent = $(this).parent();
            $parent.find(".formtips").remove();
            //验证用户名
            if( $(this).is('#merId') ){
                if( this.value==""  ){
                    var errorMsg = '请输入商户id.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{

                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }

            //验证密码
            if( $(this).is('#merPwd') ){
                if( this.value==""  ){
                    var errorMsg = '请输入密码.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }

            //验证订单号
            //if( $(this).is('#ncOrderId') ){
                //if( this.value==""  ){
                    //var errorMsg = '请输入订单号.';
                    //alert("值为："+$(this).val());
                    //$parent.append('<span class="formtips onError">'+errorMsg+'</span>');
               //}else{
                    //var okMsg = '输入正确.';
                    //$parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                //}
            //}


            //验证版本号
            if( $(this).is('#version') ){
                if( this.value==""  ){
                    var errorMsg = '请输入版本号.';
                    //alert("值为："+$(this).val());
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }

            //验证邮件
            if( $(this).is('#email') ){
                if( this.value=="" || ( this.value!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value) ) ){
                    var errorMsg = '请输入正确的E-Mail地址.';
                    $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
                }else{
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }
            }
        }).keyup(function(){
            $(this).triggerHandler("blur");
        }).focus(function(){
            $(this).triggerHandler("blur");
        });//end blur


        //重置
        $('#form_queryOrder #res').click(function(){
            $(".formtips").remove();
            $('form :input').val("");
        });
    })

