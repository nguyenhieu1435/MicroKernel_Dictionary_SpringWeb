<h1 align="center">Dictionary Web Application</h1>
<div align="center">
    <img src="https://techstack-generator.vercel.app/java-icon.svg" alt="icon" width="50" height="50" />
</div>

## 🚩 Mục lục
- [Được xây dựng bằng](#được-xây-dựng-bằng)
- [Các dependency sử dụng](#các-Dependency-sử-dụng)
- [Cách thức xử lý](#các-thức-xử-lý)
- [Demo Chương trình](#demo-Chương-trình)

## Được xây dựng bằng

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?logo=java&logoColor=white&style=for-the-badge)
![Spring](https://img.shields.io/badge/Spring-6DB33F.svg?style=for-the-badge&logo=Spring&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?logo=Thymeleaf&logoColor=white&style=for-the-badge)

## Các Dependency sử dụng

- spring-boot-starter-thymeleaf
    + Gradle
    ```xml
        org.springframework.boot:spring-boot-starter-thymeleaf
    ```
- spring-boot-starter-web
    + Gradle
    ```xml
        org.springframework.boot:spring-boot-starter-web
    ```
## Cách thức xử lý
  * Một từ của ngôn ngữ này có thể vừa là tính từ, danh từ, ... do đó ta cần một class Vocabulary để lưu từ vựng và các loại từ của từ đó
    
    ![image](https://github.com/nguyenhieu1435/MicroKernel_Dictionary_SpringWeb/assets/70377398/85faf511-c746-48e8-8b47-922534b948b3)
    
  * Class type sẽ chứa typeName như danh từ, tính từ động từ; danh sách các ví dụ và phiên âm cho loại từ đó

     ![image](https://github.com/nguyenhieu1435/MicroKernel_Dictionary_SpringWeb/assets/70377398/9f7d7981-ae07-4083-b197-dad53e806b53)


## Demo Chương trình
   * Người dùng có thể chọn tra cứu từ điển Anh -> Việt hoặc Việt -> Anh

     ![image](https://github.com/nguyenhieu1435/MicroKernel_Dictionary_SpringWeb/assets/70377398/c8166676-b1d7-4dd1-b825-b0b3f7560750)

   * Dịch từ Anh -> Việt: người dùng có thể thấy được nghĩa tiếng việt, đó là loại từ gì: Danh từ, Tính từ ... và Phiên âm của nó, ngoài ra còn có cả ví dụ
     
     ![image](https://github.com/nguyenhieu1435/MicroKernel_Dictionary_SpringWeb/assets/70377398/ffdf905d-90df-420c-a863-7eb3afac9f26)

   * Dịch từ Việt -> Anh: người dùng có thể thấy được nghĩa Tiếng anh, đó là loại từ gì: Danh từ, Tính từ ... và Phiên âm của nó, ngoài ra còn có cả ví dụ

     ![image](https://github.com/nguyenhieu1435/MicroKernel_Dictionary_SpringWeb/assets/70377398/a74e011e-1ece-43eb-b97c-b36012148b11)


