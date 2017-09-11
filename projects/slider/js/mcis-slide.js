/**
 * @license mcis-slide
 * @author Vijayaprakash
 * find me @msgtovp, msgtovp@gmail.com
 * https://msgtovp.github.io
 */
/**
 * js & css import:-
 * ----------------
 * <script src="js/mcis-slide.min.js" type="text/javascript"></script>
 * 
 * <link rel="stylesheet" href="css/mcis-slide.min.css" type="text/css" />
 * 
 * html code:-
 * ----------
 * 
 *  <div class="mcis-slide-container">
 *      <div class="mcis-slide-items mcis-slide-fade">
 *          <img src="images/banner/images2-min.jpg" style="width: 100%;" alt="" />
 *          <div class="mcis-slide-text">
 *               <h1>Heading 1</h1>
 *               <h2>Short text 1</h2>
 *          </div>
 *          <a href="#" class="mcis-slide-link">Read</a>
 *      </div>
 *      <div class="mcis-slide-items mcis-slide-fade">
 *          <img src="images/banner/images3-min.jpg" style="width: 100%;" alt="" />
 *          <div class="mcis-slide-text">
 *              <h1>Heading 2</h1>
 *              <h2>Short text 2</h2>
 *          </div>
 *          <a href="#" class="mcis-slide-link">Read</a>
 *      </div>
 *      <div class="mcis-slide-items mcis-slide-fade">
 *          <img src="images/banner/images4-min.jpg" style="width: 100%;" alt="" />
 *          <div class="mcis-slide-text">
 *              <h1>Heading 3</h1>
 *              <h2>Short text 3</h2>
 *          </div>
 *          <a href="#" class="mcis-slide-link">Read</a>
 *      </div>....
 * 
 *      <div class="mcis-slide-prev"></div>
 *      <div class="mcis-slide-next"></div>
 *  </div>
 *  <div class="mcis-slide-control">
 *      <span class="mcis-control-items"></span>
 *      <span class="mcis-control-items"></span>
 *      <span class="mcis-control-items"></span>....
 *  </div>
 * 
 * 
 * js code:-
 * --------
 * This creates with default options like
 *      {
 *          selector: '.mcis-slide-items',
 *          control: '.mcis-control-items',
 *          previous: '.mcis-slide-prev',
 *          next: 'mcis-slide-next'
 *      }
 * 
 *      $.mcisSlide();
 * 
 * you can customize options(selector for jquery) like, 
 *      1. selector (slides to hide and show)
 *      2. control (manual slide chooser)
 *      3. previous (manual previous slide slection)
 *      4. next (manual next slide slection)
 *      
 *      $.mcisSlide({
 *          selector: '<some class>',
 *          control: '<some class>',
 *          previous: '<some id>',
 *          next: '<some id>'
 *      });
 * 
 *  Note: Don't you need to customize all the option. also you can customize few selectors
 * 
 *      $.mcisSlide({
 *          selector: '<some class>',
 *          control: '<some class>',
 *      });
 *      
 *      Here the selector for next & previous was derived from default
 */

(function ($) {
    $.mcisSlider = function (options) {
        var defaults = {
            selector: '.mcis-slide-items',
            control: '.mcis-control-items',
            previous: '.mcis-slide-prev',
            next: '.mcis-slide-next'
        };
        var settings = {};
        var timer = null;
        // Extending the settings from default & options provided by user
        $.extend(settings, defaults, options);
        function goNext() {
            var index = getIndex();
            if (index === length()) {
                selectSlide(1);
            } else {
                selectSlide(index + 1);
            }
        }

        function length() {
            return $(settings.control).length;
        }

        function getIndex() {
            return $(settings.control + ".active").index() + 1;
        }

        function selectSlide(index) {
            $(settings.control).removeClass('active');
            $(settings.selector).css({
                display: "none"
            });
            $(settings.control + ":nth-child(" + index + ")").addClass("active");
            $(settings.selector + ":nth-child(" + index + ")").css({
                display: "block"
            });
            timer = setTimeout(goNext, 5000);
        }

        function autoSlide() {
            goNext();
            timer = setTimeout(autoSlide, 5000);
        }
        selectSlide(1);
        $(settings.control).click(function () {
            clearTimeout(timer);
            selectSlide($(this).index() + 1);
        });
        $(settings.previous).click(function () {
            clearTimeout(timer);
            var index = getIndex();
            if (index === 1) {
                selectSlide(length());
            } else {
                selectSlide(index - 1);
            }
        });
        $(settings.next).click(function () {
            clearTimeout(timer);
            goNext();
        });
    };
})(jQuery);
