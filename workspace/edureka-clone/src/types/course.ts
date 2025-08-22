export type CourseLevel = 'Beginner' | 'Intermediate' | 'Advanced'

export interface Course {
	id: string
	title: string
	category: string
	level: CourseLevel
	rating: number
	ratingCount: number
	durationHours: number
	price: number
	thumbnailUrl: string
	description: string
	syllabus: string[]
}