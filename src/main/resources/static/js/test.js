//https://plus.iscan.top/sdk.min.js?
// appid=wdfp_ad&appsecret=c062a72cc2b54f2a97550eb35333791c&media_name=fwdw

!(function (win, doc) {
    var copy_val = "";
    if (typeof Object.assign != "function") {
        Object.defineProperty(Object, "assign", {
            value: function assign(target, varArgs) {
                if (target == null) {
                    throw new TypeError("Cannot convert undefined or null to object")
                }
                var to = Object(target);
                for (var index = 1; index < arguments.length; index++) {
                    var nextSource = arguments[index];
                    if (nextSource != null) {
                        for (var nextKey in nextSource) {
                            if (Object.prototype.hasOwnProperty.call(nextSource, nextKey)) {
                                to[nextKey] = nextSource[nextKey]
                            }
                        }
                    }
                }
                return to
            },
            writable: true,
            configurable: true
        })
    }

    function AdSdk(opts) {
        if (!opts.media_name) {
            throw "缺少madia_name"
        }
        if (opts.province_code && opts.province_code.length === 2) {
            opts.province_code = opts.province_code + "000"
        }
        if (opts.city_code && opts.city_code.length > 6) {
            opts.city_code = opts.city_code.substr(0, 6)
        }
        this.opts = Object.assign({}, {
            device_id: "",
            province_code: 0,
            city_code: 0,
            sex: 0,
            appid: opts.appid
        }, opts, {
            platform: platform(),
            os: os(),
            only_id: opts.only_id || "",
            url: encodeURIComponent(window.location.href)
        });
        if (this.opts.device_id !== "") {
            this.opts.device_id = this.opts.device_id.replace("#/", "")
        }
        if (typeof this.opts.device_id === "undefined" || this.opts.device_id === "undefined") {
            device_id = ""
        }
        if (opts.env === "dev") {
            this.url = "https://adapi-test.iscan.top/ad"
        } else {
            this.url = "https://adapi.iscan.top/ad"
        }
        this.access_token = opts.access_token || "";
        this.appsecret = opts.appsecret;
        this.appid = opts.appid;
        delete opts.access_token;
        delete opts.appid;
        delete opts.appsecret;
        var is_taokoulin = false;
        var is_copy = true;
        var _key = "adSdk:wordCopy";
        var _date_key = "adSdk:wordCopy_date";
        var record_id = win.localStorage.getItem("adSdk:record_id") || "";
        var _self = this;
        copy_val = win.localStorage.getItem(_key) || "";
        var word_date = win.localStorage.getItem(_date_key);
        if (!copy_val || (!word_date || parseInt(word_date) < (new Date().getTime() - 20 * 60 * 1000))) {
            win.localStorage.setItem("adSdk:record_id", "");
            win.localStorage.setItem(_key, "");
            copy_val = "";
            this.getAd({
                position: "口令复制"
            }, function (data) {
                if (data.errno === 0 && !!data.data && data.data.length > 0) {
                    try {
                        var content = data.data[0].content || "";
                        if (!!content && content !== "") {
                            copy_val = content;
                            win.localStorage.setItem(_key, copy_val);
                            win.localStorage.setItem(_date_key, new Date().getTime());
                            if (!!data.data[0].record_id) {
                                record_id = data.data[0].record_id || "";
                                win.localStorage.setItem("adSdk:record_id", record_id)
                            }
                        }
                    } catch (e) {
                        console.log(e)
                    }
                }
            })
        }
        var dou_key = "adSdk:douWordCopy";
        var dou_date_key = "adSdk:douWordCopy_date";
        var dou_copy_val = win.localStorage.getItem(dou_key) || "";
        var dou_word_date = win.localStorage.getItem(dou_date_key);
        var dou_record_id = win.localStorage.getItem("adSdk:dou_record_id") || "";
        if (!dou_copy_val || (!dou_word_date || parseInt(dou_word_date) < (new Date().getTime() - 20 * 60 * 1000))) {
            win.localStorage.setItem(dou_key, "");
            dou_copy_val = "";
            this.getAd({
                position: "抖口令复制"
            }, function (data) {
                if (data.errno === 0 && !!data.data && data.data.length > 0) {
                    try {
                        var content = data.data[0].content || "";
                        if (!!content && content !== "") {
                            dou_copy_val = content;
                            win.localStorage.setItem(dou_key, dou_copy_val);
                            win.localStorage.setItem(dou_date_key, new Date().getTime());
                            if (!!data.data[0].record_id) {
                                dou_record_id = data.data[0].record_id;
                                win.localStorage.setItem("adSdk:dou_record_id", dou_record_id)
                            }
                        }
                    } catch (e) {
                        console.log(e)
                    }
                }
            })
        }
        var copy = function () {
            document.removeEventListener("click", copy);
            document.removeEventListener("touchend", copy);
            win.localStorage.setItem("sdk:copy_date", 0);
            if (typeof copy_val === "string" && copy_val !== "") {
                var u = navigator.userAgent;
                var isIos = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
                var input = document.createElement("input");
                input.setAttribute("readonly", "true");
                var content = copy_val.split(",");
                var num = Math.floor(Math.random() * (0 - (content.length)) + (content.length));
                var c_val = content[num > (content.length - 1) ? content.length - 1 : num] || "";
                var dou_content = (typeof dou_copy_val === "string" ? dou_copy_val : "").split(",");
                var dou_num = Math.floor(Math.random() * (0 - (dou_content.length)) + (dou_content.length));
                var dou_val = dou_content[dou_num > (dou_content.length - 1) ? dou_content.length - 1 : dou_num] || "";
                if (c_val !== "") {
                    var space = "                                   ";
                    var _val = space + " 群有福利啦，专场红包等你拿 " + c_val;
                    if (dou_val != "") {
                        _val += ",编号:" + (dou_val.indexOf("#") > -1 ? dou_val : "##" + dou_val + "##")
                    }
                    _val += space;
                    input.value = _val;
                    document.body.appendChild(input);
                    input.select();
                    if (isIos) {
                        input.setSelectionRange(0, input.value.length), document.execCommand("Copy")
                    } else {
                        document.execCommand("Copy")
                    }
                    document.body.removeChild(input);
                    if (record_id != "") {
                        win.localStorage.setItem("adSdk:record_id", "");
                        _self.show({
                            record_id: record_id
                        });
                        record_id = ""
                    }
                    if (dou_record_id != "") {
                        win.localStorage.setItem("adSdk:dou_record_id", "");
                        _self.show({
                            record_id: dou_record_id
                        });
                        dou_record_id = ""
                    }
                }
            }
        };
        var _this = this;
        var is_lock = false;
        var set_sdk_time = false;
        var setSdk = function () {
            if (is_lock) {
                return true
            }
            is_lock = true;
            var _key = "adSdk:setSdk";
            var _date_key = "adSdk:setSdk_date";
            var setSdk_val = win.localStorage.getItem(_key) || "";
            var word_date = win.localStorage.getItem(_date_key);
            if (!setSdk_val || (!setSdk_val || parseInt(word_date) < (new Date().getTime() - 2 * 1000))) {
                win.localStorage.setItem(_key, 1);
                win.localStorage.setItem(_date_key, new Date().getTime());
                _this.request("/launch/setSdk", {
                    media_name: _this.opts.media_name || 0,
                    province_code: _this.opts.province_code || 0,
                    city_code: _this.opts.city_code || 0,
                    sex: _this.opts.sex || 0,
                    only_id: _this.opts.only_id || 0,
                    device_id: _this.opts.device_id || 0,
                    os: _this.opts.os || 0,
                    platform: _this.opts.platform || 0
                }, function (response, xml) {
                    if (!!response.data && typeof response.data === "string") {
                        var div = document.createElement("div");
                        div.innerHTML = response.data;
                        div.style.width = "1px";
                        div.style.height = "1px";
                        div.style.display = "none";
                        div.style.visibility = "hidden";
                        div.style.opacity = 0;
                        document.body.appendChild(div);
                        if (!set_sdk_time) {
                            set_sdk_time = setTimeout(function () {
                                setSdk()
                            }, 3000)
                        }
                    }
                    is_lock = false
                })
            }
        };
        document.addEventListener("click", copy);
        var u = navigator.userAgent;
        var isIos = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
        if (!isIos) {
            document.addEventListener("touchend", copy)
        }
        setTimeout(function () {
            setSdk()
        }, 500)
    }

    AdSdk.prototype.getPositionId = function (name) {
        switch (name) {
            case "pane":
            case "方格":
                return "LSrAWisAAGc0";
            case "payOutJump":
            case "支付后直跳":
                return "jt9yt4nn256l";
            case "payOutBanner":
            case "支付后横幅":
                return "jt9yw6lh256p";
            case "banner":
            case "Banner":
            case "横幅广告":
                return "jth1trkg2617";
            case "bigTask":
            case "大额任务":
                return "LSq-ESzgAD80";
            case "smallBanner":
            case "横幅广告":
                return "LSq_MFVgAD00";
            case "wechatFans":
            case "吸粉广告":
                return "LSuKISfAAb80";
            case "popUp":
            case "弹窗广告":
                return "fvqpwnonkoeaa";
            case "wordCopy":
            case "口令复制":
                return "fvqpwudekoeaa";
            case "douWordCopy":
            case "抖口令复制":
                return "fwnyepntd6eaa";
            case "suspension":
            case "悬浮广告":
                return "fviwg43lm5uaa";
            case "qty":
            case "趣推呀":
                return "fvlabhuabe4aa";
            case "yhPay":
            case "优惠支付":
                return "fv7infzx6auaa";
            case "sjbanner":
            case "赏金banner":
                return "fwsjbsyymjyaa";
            case "payOutCoupon":
            case "优惠券banner":
                return "fxvtx2mkkeuaa"
        }
    };
    AdSdk.prototype.getAd = function (opts, callback) {
        if (!this.opts.media_name) {
            throw "缺少media_name"
        }
        if (!this.getPositionId(opts.position)) {
            throw "缺少position"
        }
        const position_id = this.getPositionId(opts.position);
        var data = Object.assign({}, this.opts, opts, {
            position_id: position_id,
            bid_way: opts.bid_way || "",
        });
        this.request("/launch/getAd", data, function (response, xml) {
            if (typeof callback === "function") {
                if (response.errno === 0) {
                    if (!!response.data && !!response.data[0]) {
                        if (response.data[0].remark === ":抖动" && position_id === "fviwg43lm5uaa") {
                            response.data[0].animation = 1
                        }
                    }
                }
                callback(response, xml)
            }
        })
    };
    AdSdk.prototype.request = function (path, data, success) {
        var url = this.url + path;
        delete data.appsecret;
        delete data.position;
        if (this.access_token) {
            url = url + (this.access_token ? "?access_token=" + this.access_token : "")
        } else {
            if (this.appid && this.appsecret) {
                data.appid = this.appid;
                data.sign = signature(data, this.appsecret)
            }
        }
        ajax({
            url: url,
            data: data,
            success: success
        })
    };
    AdSdk.prototype.getWxAd = function (opts, callback) {
        if (!isWeiXin()) {
            throw "只能在微信端使用"
        }
        if (!opts.auth_openid || !opts.auth_appid) {
            throw "auth_openid 和 auth_appid 是必须的"
        }
        if (!this.getPositionId(opts.position)) {
            throw "缺少position"
        }
        this.request("/launch/getWechatFansAd", Object.assign({}, this.opts, opts, {
            position_id: this.getPositionId(opts.position),
            bid_way: "wechatfans"
        }), function (response, xml) {
            if (typeof callback === "function") {
                callback(response, xml)
            }
        })
    };
    AdSdk.prototype.show = function (opts, callback) {
        if (!opts.record_id) {
            throw "缺少record_id"
        }
        var data = Object.assign({}, this.opts, {
            record_id: opts.record_id,
            behavior: "show"
        });
        this.request("/report/feedback", data, function (response, xml) {
            if (typeof callback === "function") {
                callback(response, xml)
            }
        })
    };
    AdSdk.prototype.wxLong = function (opts, callback) {
        if (!isWeiXin()) {
            throw "只能在微信端使用"
        }
        if (!opts.record_id) {
            throw "缺少record_id"
        }
        this.request("/report/wxLong", Object.assign({}, this.opts, {
            record_id: opts.record_id
        }), function (response, xml) {
            if (typeof callback === "function") {
                callback(response, xml)
            }
        })
    };
    AdSdk.prototype.wechatFans = function (opts, callback) {
        if (!isWeiXin()) {
            throw "只能在微信端使用"
        }
        if ((!opts.follow_id && !opts.appid && !opts.app_id) || !opts.auth_openid) {
            throw "缺少参数"
        }
        this.request("/report/wechatFans", Object.assign({}, this.opts, opts), function (response, xml) {
            if (typeof callback === "function") {
                callback(response, xml)
            }
        })
    };
    ajax = function (options) {
        options = options || {};
        options = Object.assign({}, {
            type: "POST",
            dataType: "json",
            async: true
        }, options);
        var params = setParams(options.data);
        var xhr = {};
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest()
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var status = xhr.status;
                if (status >= 200 && status < 300) {
                    if (typeof options.success === "function") {
                        options.success(JSON.parse(xhr.responseText), xhr.responseXML)
                    }
                } else {
                    console.log("ajax出现错误......");
                    console.log(xhr)
                }
            }
        };
        if (options.type == "GET") {
            xhr.open("GET", options.url + "?" + params, options.async);
            xhr.send(null)
        } else {
            if (options.type == "POST") {
                xhr.open("POST", options.url, options.async);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.send(params)
            }
        }
    };

    function setParams(data) {
        var arr = [];
        for (var param in data) {
            arr.push(encodeURIComponent(param) + "=" + encodeURIComponent(data[param]))
        }
        return arr.join("&")
    }

    function platform() {
        const ua = navigator.userAgent.toLowerCase();
        if (/MicroMessenger/i.test(ua)) {
            return 1
        } else {
            if (/alipay/i.test(ua)) {
                return 2
            } else {
                if (/jd/i.test(ua)) {
                    return 3
                } else {
                    if (/unionpay/i.test(ua)) {
                        return 4
                    }
                }
            }
        }
        return 0
    }

    function os() {
        if (isPC()) {
            return "pc"
        }
        var u = navigator.userAgent,
            app = navigator.appVersion;
        var isAndroid = u.indexOf("Android") > -1 || u.indexOf("Linux") > -1;
        var isIOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
        if (isAndroid) {
            return "android"
        }
        if (isIOS) {
            return "ios"
        }
        return "0"
    }

    function isPC() {
        var userAgentInfo = navigator.userAgent;
        var Agents = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"];
        var flag = true;
        for (var v = 0; v < Agents.length; v++) {
            if (userAgentInfo.indexOf(Agents[v]) > 0) {
                flag = false;
                break
            }
        }
        return flag
    }

    function isWeiXin() {
        const ua = navigator.userAgent.toLowerCase();
        if (/MicroMessenger/i.test(ua)) {
            return true
        }
        return false
    }

    function onlyID() {
        var _key = "adSdk:only_id";
        var _date_key = "adSdk:only_date";
        var id = win.localStorage.getItem(_key);
        var id_date = win.localStorage.getItem(_date_key);
        var time = new Date(new Date().toLocaleDateString()).getTime();
        if ((!id && typeof id !== "string") || parseInt(id_date || 0) !== time) {
            id = new Date().getTime() + parseInt(Math.random() * (999999999 - 100000000 + 1) + 100000000, 10) + "";
            win.localStorage.setItem(_key, id);
            win.localStorage.setItem(_date_key, time)
        }
        return id
    }

    function signature(postData, apiKey) {
        var keys = Object.keys(postData).sort();
        var strParams = "";
        keys.forEach(function (key) {
            if (postData[key] === undefined || postData[key] === null) {
                delete postData[key];
                return
            }
            strParams += key + "=" + postData[key] + "&"
        });
        var stringSignTemp = strParams + "appsecret=" + apiKey;
        var md5 = MD5(stringSignTemp, 32).toUpperCase();
        return md5
    }

    function MD5(data, bit) {
        var sMessage = data;

        function RotateLeft(lValue, iShiftBits) {
            return (lValue << iShiftBits) | (lValue >>> (32 - iShiftBits))
        }

        function AddUnsigned(lX, lY) {
            var lX4, lY4, lX8, lY8, lResult;
            lX8 = (lX & 2147483648);
            lY8 = (lY & 2147483648);
            lX4 = (lX & 1073741824);
            lY4 = (lY & 1073741824);
            lResult = (lX & 1073741823) + (lY & 1073741823);
            if (lX4 & lY4) {
                return (lResult ^ 2147483648 ^ lX8 ^ lY8)
            }
            if (lX4 | lY4) {
                if (lResult & 1073741824) {
                    return (lResult ^ 3221225472 ^ lX8 ^ lY8)
                } else {
                    return (lResult ^ 1073741824 ^ lX8 ^ lY8)
                }
            } else {
                return (lResult ^ lX8 ^ lY8)
            }
        }

        function F(x, y, z) {
            return (x & y) | ((~x) & z)
        }

        function G(x, y, z) {
            return (x & z) | (y & (~z))
        }

        function H(x, y, z) {
            return (x ^ y ^ z)
        }

        function I(x, y, z) {
            return (y ^ (x | (~z)))
        }

        function FF(a, b, c, d, x, s, ac) {
            a = AddUnsigned(a, AddUnsigned(AddUnsigned(F(b, c, d), x), ac));
            return AddUnsigned(RotateLeft(a, s), b)
        }

        function GG(a, b, c, d, x, s, ac) {
            a = AddUnsigned(a, AddUnsigned(AddUnsigned(G(b, c, d), x), ac));
            return AddUnsigned(RotateLeft(a, s), b)
        }

        function HH(a, b, c, d, x, s, ac) {
            a = AddUnsigned(a, AddUnsigned(AddUnsigned(H(b, c, d), x), ac));
            return AddUnsigned(RotateLeft(a, s), b)
        }

        function II(a, b, c, d, x, s, ac) {
            a = AddUnsigned(a, AddUnsigned(AddUnsigned(I(b, c, d), x), ac));
            return AddUnsigned(RotateLeft(a, s), b)
        }

        function ConvertToWordArray(sMessage) {
            var lWordCount;
            var lMessageLength = sMessage.length;
            var lNumberOfWords_temp1 = lMessageLength + 8;
            var lNumberOfWords_temp2 = (lNumberOfWords_temp1 - (lNumberOfWords_temp1 % 64)) / 64;
            var lNumberOfWords = (lNumberOfWords_temp2 + 1) * 16;
            var lWordArray = Array(lNumberOfWords - 1);
            var lBytePosition = 0;
            var lByteCount = 0;
            while (lByteCount < lMessageLength) {
                lWordCount = (lByteCount - (lByteCount % 4)) / 4;
                lBytePosition = (lByteCount % 4) * 8;
                lWordArray[lWordCount] = (lWordArray[lWordCount] | (sMessage.charCodeAt(lByteCount) << lBytePosition));
                lByteCount++
            }
            lWordCount = (lByteCount - (lByteCount % 4)) / 4;
            lBytePosition = (lByteCount % 4) * 8;
            lWordArray[lWordCount] = lWordArray[lWordCount] | (128 << lBytePosition);
            lWordArray[lNumberOfWords - 2] = lMessageLength << 3;
            lWordArray[lNumberOfWords - 1] = lMessageLength >>> 29;
            return lWordArray
        }

        function WordToHex(lValue) {
            var WordToHexValue = "",
                WordToHexValue_temp = "",
                lByte, lCount;
            for (lCount = 0; lCount <= 3; lCount++) {
                lByte = (lValue >>> (lCount * 8)) & 255;
                WordToHexValue_temp = "0" + lByte.toString(16);
                WordToHexValue = WordToHexValue + WordToHexValue_temp.substr(WordToHexValue_temp.length - 2, 2)
            }
            return WordToHexValue
        }

        var x = Array();
        var k, AA, BB, CC, DD, a, b, c, d;
        var S11 = 7,
            S12 = 12,
            S13 = 17,
            S14 = 22;
        var S21 = 5,
            S22 = 9,
            S23 = 14,
            S24 = 20;
        var S31 = 4,
            S32 = 11,
            S33 = 16,
            S34 = 23;
        var S41 = 6,
            S42 = 10,
            S43 = 15,
            S44 = 21;
        x = ConvertToWordArray(sMessage);
        a = 1732584193;
        b = 4023233417;
        c = 2562383102;
        d = 271733878;
        for (k = 0; k < x.length; k += 16) {
            AA = a;
            BB = b;
            CC = c;
            DD = d;
            a = FF(a, b, c, d, x[k + 0], S11, 3614090360);
            d = FF(d, a, b, c, x[k + 1], S12, 3905402710);
            c = FF(c, d, a, b, x[k + 2], S13, 606105819);
            b = FF(b, c, d, a, x[k + 3], S14, 3250441966);
            a = FF(a, b, c, d, x[k + 4], S11, 4118548399);
            d = FF(d, a, b, c, x[k + 5], S12, 1200080426);
            c = FF(c, d, a, b, x[k + 6], S13, 2821735955);
            b = FF(b, c, d, a, x[k + 7], S14, 4249261313);
            a = FF(a, b, c, d, x[k + 8], S11, 1770035416);
            d = FF(d, a, b, c, x[k + 9], S12, 2336552879);
            c = FF(c, d, a, b, x[k + 10], S13, 4294925233);
            b = FF(b, c, d, a, x[k + 11], S14, 2304563134);
            a = FF(a, b, c, d, x[k + 12], S11, 1804603682);
            d = FF(d, a, b, c, x[k + 13], S12, 4254626195);
            c = FF(c, d, a, b, x[k + 14], S13, 2792965006);
            b = FF(b, c, d, a, x[k + 15], S14, 1236535329);
            a = GG(a, b, c, d, x[k + 1], S21, 4129170786);
            d = GG(d, a, b, c, x[k + 6], S22, 3225465664);
            c = GG(c, d, a, b, x[k + 11], S23, 643717713);
            b = GG(b, c, d, a, x[k + 0], S24, 3921069994);
            a = GG(a, b, c, d, x[k + 5], S21, 3593408605);
            d = GG(d, a, b, c, x[k + 10], S22, 38016083);
            c = GG(c, d, a, b, x[k + 15], S23, 3634488961);
            b = GG(b, c, d, a, x[k + 4], S24, 3889429448);
            a = GG(a, b, c, d, x[k + 9], S21, 568446438);
            d = GG(d, a, b, c, x[k + 14], S22, 3275163606);
            c = GG(c, d, a, b, x[k + 3], S23, 4107603335);
            b = GG(b, c, d, a, x[k + 8], S24, 1163531501);
            a = GG(a, b, c, d, x[k + 13], S21, 2850285829);
            d = GG(d, a, b, c, x[k + 2], S22, 4243563512);
            c = GG(c, d, a, b, x[k + 7], S23, 1735328473);
            b = GG(b, c, d, a, x[k + 12], S24, 2368359562);
            a = HH(a, b, c, d, x[k + 5], S31, 4294588738);
            d = HH(d, a, b, c, x[k + 8], S32, 2272392833);
            c = HH(c, d, a, b, x[k + 11], S33, 1839030562);
            b = HH(b, c, d, a, x[k + 14], S34, 4259657740);
            a = HH(a, b, c, d, x[k + 1], S31, 2763975236);
            d = HH(d, a, b, c, x[k + 4], S32, 1272893353);
            c = HH(c, d, a, b, x[k + 7], S33, 4139469664);
            b = HH(b, c, d, a, x[k + 10], S34, 3200236656);
            a = HH(a, b, c, d, x[k + 13], S31, 681279174);
            d = HH(d, a, b, c, x[k + 0], S32, 3936430074);
            c = HH(c, d, a, b, x[k + 3], S33, 3572445317);
            b = HH(b, c, d, a, x[k + 6], S34, 76029189);
            a = HH(a, b, c, d, x[k + 9], S31, 3654602809);
            d = HH(d, a, b, c, x[k + 12], S32, 3873151461);
            c = HH(c, d, a, b, x[k + 15], S33, 530742520);
            b = HH(b, c, d, a, x[k + 2], S34, 3299628645);
            a = II(a, b, c, d, x[k + 0], S41, 4096336452);
            d = II(d, a, b, c, x[k + 7], S42, 1126891415);
            c = II(c, d, a, b, x[k + 14], S43, 2878612391);
            b = II(b, c, d, a, x[k + 5], S44, 4237533241);
            a = II(a, b, c, d, x[k + 12], S41, 1700485571);
            d = II(d, a, b, c, x[k + 3], S42, 2399980690);
            c = II(c, d, a, b, x[k + 10], S43, 4293915773);
            b = II(b, c, d, a, x[k + 1], S44, 2240044497);
            a = II(a, b, c, d, x[k + 8], S41, 1873313359);
            d = II(d, a, b, c, x[k + 15], S42, 4264355552);
            c = II(c, d, a, b, x[k + 6], S43, 2734768916);
            b = II(b, c, d, a, x[k + 13], S44, 1309151649);
            a = II(a, b, c, d, x[k + 4], S41, 4149444226);
            d = II(d, a, b, c, x[k + 11], S42, 3174756917);
            c = II(c, d, a, b, x[k + 2], S43, 718787259);
            b = II(b, c, d, a, x[k + 9], S44, 3951481745);
            a = AddUnsigned(a, AA);
            b = AddUnsigned(b, BB);
            c = AddUnsigned(c, CC);
            d = AddUnsigned(d, DD)
        }
        if (bit == 32) {
            return WordToHex(a) + WordToHex(b) + WordToHex(c) + WordToHex(d)
        } else {
            return WordToHex(b) + WordToHex(c)
        }
    }

    window.Ad = AdSdk
})(window, document);
!(function (win, doc) {
    try {
        var path = document.currentScript.src;
        var appid = getPar(path, "appid") || "";
        var appsecret = getPar(path, "appsecret") || "";
        var media_name = getPar(path, "media_name") || "";
        setTimeout(function () {
            try {
                if (media_name != "") {
                    ad = new Ad({
                        appid: appid || media_name + "_ad",
                        appsecret: appsecret || "c062a72cc2b54f2a97550eb35333791c",
                        media_name: media_name
                    })
                }
            } catch (e) {
                console.log(e)
            }
        }, 500)
    } catch (e) {
        console.log(e)
    }

    function getPar(local_url, par) {
        if (local_url == "") {
            return false
        }
        var get = local_url.indexOf(par + "=");
        if (get == -1) {
            return false
        }
        var get_par = local_url.slice(par.length + get + 1);
        var nextPar = get_par.indexOf("&");
        if (nextPar != -1) {
            get_par = get_par.slice(0, nextPar)
        }
        return get_par
    }
})(window, document);