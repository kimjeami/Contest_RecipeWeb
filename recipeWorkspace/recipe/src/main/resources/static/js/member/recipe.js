document.addEventListener("DOMContentLoaded", function() {
    const slides = document.querySelectorAll('.ad-slide');
    const adSlider = document.querySelector('.ad-slider');
    let currentIndex = 0;

    function showSlide(index) {
        adSlider.style.transform = `translateX(-${index * 100}%)`; // 슬라이드 이동
    }

    showSlide(currentIndex);

    document.querySelector('.next').addEventListener('click', function() {
        currentIndex = (currentIndex + 1) % slides.length;
        showSlide(currentIndex);
    });

    document.querySelector('.prev').addEventListener('click', function() {
        currentIndex = (currentIndex - 1 + slides.length) % slides.length;
        showSlide(currentIndex);
    });
});
