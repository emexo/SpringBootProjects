import type { Course } from '../types/course'

export const courses: Course[] = [
	{
		id: 'aws-solutions-architect',
		title: 'AWS Solutions Architect Certification Training',
		category: 'Cloud Computing',
		level: 'Intermediate',
		rating: 4.7,
		ratingCount: 12450,
		durationHours: 36,
		price: 399,
		thumbnailUrl: 'https://images.unsplash.com/photo-1518779578993-ec3579fee39f?q=80&w=800&auto=format&fit=crop',
		description: 'Master AWS architectural principles, services, and best practices to design and deploy scalable systems on AWS.',
		syllabus: ['AWS Compute & Networking', 'Storage & Databases', 'Security & IAM', 'High Availability & Fault Tolerance']
	},
	{
		id: 'devops-mastery',
		title: 'DevOps Engineer Masters Program',
		category: 'DevOps',
		level: 'Advanced',
		rating: 4.6,
		ratingCount: 9800,
		durationHours: 48,
		price: 499,
		thumbnailUrl: 'https://images.unsplash.com/photo-1515879218367-8466d910aaa4?q=80&w=800&auto=format&fit=crop',
		description: 'Gain end-to-end DevOps skills with CI/CD, containerization, orchestration, monitoring, and cloud deployments.',
		syllabus: ['Linux & Shell', 'Git & CI/CD', 'Docker & Kubernetes', 'Monitoring & Logging']
	},
	{
		id: 'data-science-with-python',
		title: 'Data Science with Python',
		category: 'Data Science',
		level: 'Beginner',
		rating: 4.5,
		ratingCount: 15200,
		durationHours: 30,
		price: 349,
		thumbnailUrl: 'https://images.unsplash.com/photo-1517148815978-75f6acaaf32c?q=80&w=800&auto=format&fit=crop',
		description: 'Learn data analysis, visualization, and machine learning with Python using NumPy, pandas, and scikit-learn.',
		syllabus: ['Python Basics', 'Data Wrangling', 'Visualization', 'ML Fundamentals']
	},
	{
		id: 'fullstack-react-node',
		title: 'Full-Stack Web Development with React & Node',
		category: 'Programming',
		level: 'Intermediate',
		rating: 4.6,
		ratingCount: 8700,
		durationHours: 42,
		price: 449,
		thumbnailUrl: 'https://images.unsplash.com/photo-1555066931-4365d14bab8c?q=80&w=800&auto=format&fit=crop',
		description: 'Build modern web apps with React, TypeScript, Node.js, and REST APIs following best practices.',
		syllabus: ['React & TS', 'Node & Express', 'Auth & JWT', 'Testing & Deployment']
	},
	{
		id: 'ai-ml-specialization',
		title: 'AI & Machine Learning Specialization',
		category: 'Artificial Intelligence',
		level: 'Advanced',
		rating: 4.7,
		ratingCount: 6400,
		durationHours: 60,
		price: 599,
		thumbnailUrl: 'https://images.unsplash.com/photo-1542831371-29b0f74f9713?q=80&w=800&auto=format&fit=crop',
		description: 'Deep dive into supervised, unsupervised learning, deep learning, and MLOps pipelines.',
		syllabus: ['ML Refresher', 'Deep Learning', 'NLP & CV', 'MLOps & Deployment']
	},
	{
		id: 'cybersecurity-essentials',
		title: 'Cybersecurity Essentials',
		category: 'Security',
		level: 'Beginner',
		rating: 4.4,
		ratingCount: 5200,
		durationHours: 28,
		price: 299,
		thumbnailUrl: 'https://images.unsplash.com/photo-1555949963-aa79dcee981d?q=80&w=800&auto=format&fit=crop',
		description: 'Understand core cybersecurity concepts, threat modeling, and defensive strategies.',
		syllabus: ['Network Basics', 'Threats & Vulnerabilities', 'Defense in Depth', 'Security Operations']
	},
	{
		id: 'azure-administrator',
		title: 'Microsoft Azure Administrator AZ-104',
		category: 'Cloud Computing',
		level: 'Intermediate',
		rating: 4.5,
		ratingCount: 4100,
		durationHours: 34,
		price: 379,
		thumbnailUrl: 'https://images.unsplash.com/photo-1531297484001-80022131f5a1?q=80&w=800&auto=format&fit=crop',
		description: 'Prepare for AZ-104 with hands-on labs on Azure compute, storage, networking, and security.',
		syllabus: ['Azure Compute', 'Storage & Backup', 'Virtual Networking', 'Identity & Security']
	},
	{
		id: 'kubernetes-admin',
		title: 'Kubernetes Administrator (CKA)',
		category: 'DevOps',
		level: 'Advanced',
		rating: 4.6,
		ratingCount: 7300,
		durationHours: 38,
		price: 429,
		thumbnailUrl: 'https://images.unsplash.com/photo-1498050108023-c5249f4df085?q=80&w=800&auto=format&fit=crop',
		description: 'Master Kubernetes cluster operations, networking, storage, and troubleshooting for the CKA exam.',
		syllabus: ['Core Concepts', 'Workloads & Scheduling', 'Services & Networking', 'Storage & Security']
	},
	{
		id: 'python-for-beginners',
		title: 'Python Programming for Beginners',
		category: 'Programming',
		level: 'Beginner',
		rating: 4.3,
		ratingCount: 18000,
		durationHours: 24,
		price: 199,
		thumbnailUrl: 'https://images.unsplash.com/photo-1517694712202-14dd9538aa97?q=80&w=800&auto=format&fit=crop',
		description: 'Start coding with Python fundamentals, problem solving, and building small projects.',
		syllabus: ['Syntax & Types', 'Control Flow', 'Functions & Modules', 'Projects']
	}
]

export const categories = Array.from(new Set(courses.map(c => c.category)))