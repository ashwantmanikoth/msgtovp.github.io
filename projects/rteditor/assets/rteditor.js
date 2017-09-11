(function (window) {
    var $ = window.jQuery;
    $.fn.rteditor = function (options) {
        var editor;
        var defaults = {
            name: "rte_value",
            live: false
        };
        var settings = $.extend({}, defaults, options);
        if (this.length < 1) {
            console.error("No element found for particular selectors.\nrteditor load fails");
            return;
        }
        if (this.length > 1) {
            console.warn("More than one element found, but we have taken the first element");
            editor = this[0];
        }
        var template = '<div class="rteditor">\
        <div class="controls">\
        <div class=""></div>\
        </div>\
        <div class="content"></div>\
        </div>';
        $(editor).html(template).find('.content').attr("contenteditable", "true").html("<p>Test String</p>");
    };
})(window);