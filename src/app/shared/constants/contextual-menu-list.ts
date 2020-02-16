export const deafultItems = [
    'Home',
    'Properties',
    'Projects',
    'Brokers',
];

export const menu = [{
    'defaults': deafultItems,
    'dashboards': [{
        'name': 'Home',
        'route': 'home',
        'iconPath': ''
    },
    {
        'name': 'Properties',
        'route': '',
        'iconPath': ''
    },
    {
        'name': 'Projects',
        'route': '',
        'iconPath': ''
    },
    {
        'name': 'Brokers',
        'route': '',
        'iconPath': ''
    },
    {
        'name': 'About us',
        'route': '',
        'iconPath': ''
    },
    {
        'name': 'Contact Us',
        'route': '',
        'iconPath': ''
    },
    {
        'name': 'Admin',
        'route': '',
        'iconPath': '',
        'dashboards': [
            {
                'name': 'Properties',
                'route': 'admin',
                'iconPath': ''
            },
            {
                'name': 'Projects',
                'route': '',
                'iconPath': ''
            },
            {
                'name': 'Brokers',
                'route': '',
                'iconPath': ''
            },
            {
                'name': 'Users',
                'route': '',
                'iconPath': ''
            },
            {
                'name': 'Company Profile',
                'route': '',
                'iconPath': ''
            }

        ]
    }
    ]
}];