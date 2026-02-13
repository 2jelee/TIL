<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <div class="bmi-search">
        <div class="col-3">
            <p class="col-3-title">성별정보</p>
            <dl>
                <dt>
                    <label for="searchSexFlagM">성별</label>
                </dt>
                <dd>
<!-- 	                                 <div class="btn-group" data-toggle="buttons"> -->
                    <div class="btn-group">
                        <label for="searchSexFlagM" class="btn btn-default active" style="padding-bottom:35px; " onKeyPress="return fn_onlyNumber();">
                            <input type="radio" title="성별" name="searchSexFlag" id="searchSexFlagM" style="margin-top:15px; width:25px; opacity:1; z-index:1;" checked>
                            남자</label>
                        <label for="searchSexFlagF" class="btn btn-default"  style="padding-bottom:35px;">
                            <input type="radio" title="성별" name="searchSexFlag" id="searchSexFlagF" style="margin-top:15px; width:25px; opacity:1; z-index:1;">
                            여자</label>
                    </div>
                </dd>
            </dl>
        </div>
        <div class="col-3">
            <p class="col-3-title">신체정보</p>
            <dl>
                <dt>
                    <label for="searchHeight">키(cm)</label>
                </dt>
                <dd>
                    <input type="text" name="searchHeight" size="10" maxlength="5" value="" id="searchHeight" title="키를 입력해주세요" style="ime-mode:disabled;" onKeyPress="return fn_onlyNumber();">
                </dd>
                <dt>
                    <label for="searchWeight">몸무게(kg)</label>
                </dt>
                <dd>
                    <input type="text" name="searchWeight" size="10" maxlength="5" value="" id="searchWeight" title="몸무게를 입력해주세요" style="ime-mode:disabled;" onKeyPress="return fn_onlyNumber();">
                </dd>
                <dt>
                    <label for="searchAge">나이(세)</label>
                </dt>
                <dd>
                    <input type="text" name="searchAge" size="7" maxlength="5" value="" id="searchAge" title="나이를 입력해주세요" style="ime-mode:disabled;" onKeyPress="return fn_onlyNumber();">
                </dd>
            </dl>
        </div>
        <div class="col-3">
            <p class="col-3-title">비만도결과</p>
            <dl>
                <dt>
                    <label for="bmi">체질량지수</label>
                </dt>
                <dd>
                    <input type="text" name="bmi" size="25" maxlength="100" value="" id="bmi" title="체질량지수를 입력해주세요" readonly>
                </dd>
                <dd class="ddfull">
                    <input type="text" name="bmiTxt" size="25" maxlength="100" value="" id="bmiTxt" title="겸색결과를 입력해주세요" readonly>
                </dd>
                <dd class="ddfull">
                    <a href="javascript:;" class="btn btn-default btn-block" onClick="javascript:fn_reset();">초기화</a>
                </dd>
            </dl>
        </div>
    </div>
    <a href="javascript:fn_calBMI();" class="btn btn-default btn-block" role="button">계산하기</a>
</fieldset>
</td>       
</body>
</html>