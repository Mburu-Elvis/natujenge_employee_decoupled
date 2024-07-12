app.controller('JobsController', function ($scope) {
    $scope.jobs = [
        {
            jobTitle: 'ML Developer',
            jobDescription: 'Machine Learning/Data science specialist is needed for the evaluation of UNet model with some changes in architecture and loss, I have Colab notebook with all pipeline of model training.',
            price: '500.00',
            timeline: 'flexible',
            tags: ['Machine Learning', 'Data Science'],
            datePosted: '2024-07-01',
            bids: '0-10'
        },
        {
            jobTitle: 'Frontend Developer',
            jobDescription: 'Seeking a skilled frontend developer with experience in AngularJS to build responsive web interfaces.',
            price: '750.00',
            timeline: '2 weeks',
            tags: ['AngularJS', 'HTML', 'CSS'],
            datePosted: '2024-07-02',
            bids: '5-15'
        },
        {
            jobTitle: 'Backend Developer',
            jobDescription: 'Looking for a backend developer proficient in Spring Boot to implement RESTful APIs.',
            price: '1000.00',
            timeline: '1 month',
            tags: ['Spring Boot', 'Java', 'REST'],
            datePosted: '2024-07-03',
            bids: '10-20'
        },
        {
            jobTitle: 'Mobile App Developer',
            jobDescription: 'Need a developer to create a cross-platform mobile application using React Native.',
            price: '1200.00',
            timeline: '1.5 months',
            tags: ['React Native', 'Mobile Development'],
            datePosted: '2024-07-04',
            bids: '15-25'
        },
        {
            jobTitle: 'Data Analyst',
            jobDescription: 'A data analyst is needed to process and visualize large datasets using Python and Tableau.',
            price: '600.00',
            timeline: '3 weeks',
            tags: ['Python', 'Tableau', 'Data Analysis'],
            datePosted: '2024-07-05',
            bids: '0-5'
        },
        {
            jobTitle: 'DevOps Engineer',
            jobDescription: 'Looking for a DevOps engineer to set up CI/CD pipelines and manage cloud infrastructure.',
            price: '900.00',
            timeline: '1 month',
            tags: ['CI/CD', 'AWS', 'DevOps'],
            datePosted: '2024-07-06',
            bids: '10-15'
        },
        {
            jobTitle: 'UI/UX Designer',
            jobDescription: 'Seeking a creative UI/UX designer to design intuitive and user-friendly interfaces.',
            price: '800.00',
            timeline: '3 weeks',
            tags: ['UI/UX', 'Design', 'Figma'],
            datePosted: '2024-07-07',
            bids: '5-10'
        },
        {
            jobTitle: 'Cybersecurity Specialist',
            jobDescription: 'A cybersecurity specialist is needed to perform a security audit and implement best practices.',
            price: '1100.00',
            timeline: '1 month',
            tags: ['Cybersecurity', 'Security Audit'],
            datePosted: '2024-07-01',
            bids: '20-30'
        },
        {
            jobTitle: 'Content Writer',
            jobDescription: 'Looking for a content writer to produce high-quality articles and blog posts on tech topics.',
            price: '400.00',
            timeline: '1 week',
            tags: ['Content Writing', 'Blogging', 'SEO'],
            datePosted: '2024-07-02',
            bids: '0-10'
        },
        {
            jobTitle: 'QA Engineer',
            jobDescription: 'Need a QA engineer to write and execute test cases for a web application.',
            price: '650.00',
            timeline: '2 weeks',
            tags: ['QA', 'Testing', 'Automation'],
            datePosted: '2024-07-03',
            bids: '10-20'
        }
    ];
    

});